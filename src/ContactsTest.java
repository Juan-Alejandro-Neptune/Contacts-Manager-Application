import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.io.IOException;

public class ContactsTest {

        public static String[] MainMenu = {"View Contacts.", "Add a new contact.", "Search a contact by name.", "Delete an existing contact.","Exit"};
        public static Input input = new Input();


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

    public static void createContact() {

    }


    public static void main() {
        System.out.println("Would you like to look at the contact menu?");
        if(input.yesNo()){
            mainMenu();
        }else{
            System.out.println("Thank you come again!");
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
            case "1" -> {Path namePath = Paths.get("src/contact", "contacts.txt");
                List<String> currentList = new ArrayList<>();
                try {
                    currentList = Files.readAllLines(namePath);
                } catch (IOException ioe){
                    ioe.printStackTrace();
                }
                for (String line: currentList) {
                    System.out.println(line);
                }
                main();
            }
            case "2" ->System.out.println("Thank you for your time. Goodbye!") ;
            case "3" ->System.out.println("Thank you for your time. Goodbye!") ;
            case "4" ->System.out.println("Thank you for your time. Goodbye!") ;
            case "5" -> {
                System.out.println("Thank you for your time. Goodbye!");
                main();
            }
            default -> {
                System.out.println("That is not a valid option...");
                mainMenu();
            }
        }
    }

    public static void main(String[] args) {
        createPath();
        main();
    }
}
