import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import static java.nio.file.Files.createFile;

public class ContactsTest extends FileIO{
        public static String[] MainMenu = {"View Contacts.", "Add a new contact.", "Search a contact by name.", "Delete an existing contact.","Exit"};
        public static Input input = new Input();

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
        String[] contactName = {"John", "Carl", "Jerry"};

        System.out.println("Enter an option (1, 2, 3, 4 or 5):");
            for(int i = 0; i < MainMenu.length; ++i){
                System.out.println(i + 1 + ". " + MainMenu[i]);
            }
        String userInput = scanner.next();

        switch (userInput) {
            case "1" -> {Path namePath = Paths.get("data", "contacts.txt");
                List<String> groceryList = null;
                try {
                    groceryList = Files.readAllLines(namePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < groceryList.size(); i += 1) {
                    System.out.println((i + 1) + ": " + groceryList.get(i));
                }
            }
            case "2" ->System.out.println("Thank you for your time. Goodbye!") ;
            case "3" ->System.out.println("Thank you for your time. Goodbye!") ;
            case "4" ->System.out.println("Thank you for your time. Goodbye!") ;
            case "5" -> {
                System.out.println("Thank you for your time. Goodbye!");
                main();
            }
            default -> System.out.println("That is not a valid option...");
        }
    }

    public static void main(String[] args) {
        main();
    }
}
