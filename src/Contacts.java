import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contacts {
    public static String[] MainMenu = {"View Contacts.", "Add a new contact.", "Search a contact by name.", "Delete an existing contact.","Exit"};
    public static Input input = new Input();
    private static List<String> currentList = new ArrayList<>();
    private static final Path contacTxt = Paths.get("src/contact/contacts.txt");


    public static void createPath() {
        Path toOurDataPlace = Paths.get("src/contact");
        try {
            if (Files.notExists(toOurDataPlace)) {
                Files.createDirectory(toOurDataPlace);
            } else {
                System.out.println("The " + toOurDataPlace + " directory already exists");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");
        try {
            if (Files.notExists(toOurDataFile)) {
                Files.createFile(toOurDataFile);
            } else {
                System.out.println("The " + toOurDataFile + " directory already exists");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static String createContact() {
        Input input = new Input();
        String userContactName = input.getString();
        int userContactNum = input.getInt();
        currentList.add(userContactName + " | " + userContactNum + " | ");
        return userContactName + " | " + userContactNum + " | " + "\n";
    }

    public static void addToContacts() {
        try {
            Files.writeString(contacTxt, createContact(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteContact(){
        Scanner userSearch = new Scanner(System.in);
        System.out.println("Please search contact name you would like to delete: ");
        String search = userSearch.nextLine();
        try {
            currentList = Files.readAllLines(contacTxt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < currentList.size(); i++) {
            if (currentList.get(i).startsWith(search)) {
                System.out.println("Contact Removed.");
                currentList.remove(i);
                System.out.println("The contact of: " + search + " has been deleted");
                try {
                    Files.write(contacTxt, currentList);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main() {
        System.out.println("Would you like to look at the contact menu?");
        if(input.yesNo()){
            mainMenu();
        }else{
            System.out.println("Thank you come again!");
        }
    }

    public static void returnMenu() {
        System.out.println("Would you like to return to the contact menu?");
        if(input.yesNo()){
            mainMenu();
        }else{
            System.out.println("Thank you come again!");
        }
    }

    public static void showContact(){
        try{
            currentList = Files.readAllLines(contacTxt);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        System.out.println("Name        |  Phone Number  |");
        System.out.println("---------------------------------");
        for (String line: currentList) {
            System.out.println(line);
        }
        System.out.println("");
    }

    public static void searchContact(){
        Scanner userSearch = new Scanner(System.in);
        System.out.println("Please search contact name or number:");
        String search = userSearch.nextLine();
        try {
            currentList = Files.readAllLines(contacTxt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Contact:\n");
        for (String s : currentList) {
            if(s.toLowerCase().startsWith(search.toLowerCase())){
                System.out.println(s);
            }
        }

    }

    public static void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");
        for(int i = 0; i < MainMenu.length; ++i){
            System.out.println(i + 1 + ". " + MainMenu[i]);
        }
        String userInput = scanner.next();
        switch (userInput) {
            case "1" -> {
                showContact();
                returnMenu();
            }
            case "2" -> {
                addToContacts();
                returnMenu();
            }
            case "3" ->{
                searchContact();
                returnMenu();
            }
            case "4" ->{
                deleteContact();
                returnMenu();

            }
            case "5" -> {
                System.out.println("Thank you for your time. Goodbye!");
            }
            default -> {
                System.out.println("That is not a valid option...");
                mainMenu();
            }
        }
    }
}
