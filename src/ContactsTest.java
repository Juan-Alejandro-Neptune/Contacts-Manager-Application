import java.util.Scanner;

public class ContactsTest extends Contacts{
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
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");
            for(int i = 0; i < MainMenu.length; ++i){
                System.out.println(i + 1 + ". " + MainMenu[i]);
            }
        String userInput = scanner.next();
            switch (userInput){
                case "1":
                    System.out.println("Hello");
                    break;
                default:
                    System.out.println("That is not a valid option...");
                    break;
            }



    }

    public static void main(String[] args) {
        main();
    }
}
