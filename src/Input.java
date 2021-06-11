import java.util.Scanner;
public class Input {


        private Scanner scanner;
        public Input() {
            this.scanner = new Scanner(System.in);
        }

        public String getString() {
            return getString("Enter Contacts Name");
        }
        public String getString(String prompt){
            System.out.println(prompt);
            return this.scanner.nextLine();
        }

        public boolean yesNo(){
            return yesNo("Enter Yes or No");
        }
        public boolean yesNo(String prompt){
            System.out.println(prompt);
            String userResponse = this.scanner.next();
            if (userResponse.equalsIgnoreCase("yes") || userResponse.equalsIgnoreCase("y") || userResponse.equalsIgnoreCase("ya")){
                return true;
            } else {
                return false;
            }
        }
        public int getInt(){
            System.out.println("Enter Contacts Phone Number");
            return this.scanner.nextInt();
        }
        public int getInt (int min, int max) {
            System.out.printf("Please enter a number between %d and %d%n", min, max);
            int userInput = this.scanner.nextInt();
            if (userInput > min && userInput < max) {
                return userInput;
            } else {
                System.out.println("Please enter a number in the given range");
                return getInt(min, max);
            }
        }

        public double getDouble(double min, double max) {
            System.out.printf(String.format("Enter a number between %f and %f%n", min, max));
            double userInput3 = this.scanner.nextDouble();
            if (userInput3 > min && userInput3 < max) {
                return userInput3;
            } else {
                System.out.println("Please enter a number in the given range");
                return getDouble(min, max);
            }
        }

        public double getDouble() {
            return this.scanner.nextDouble();
        }

        public int getInt2(){
            try{
                return Integer.valueOf(getString("Enter a Integer"));
            } catch (NumberFormatException e){
                System.err.println(e.getMessage() + " Is the wrong input, try again");
                return getInt2();
            }
        }

        public double getDouble2(){
            try{
                return Double.valueOf(getString("Enter a Double"));
            }catch (NumberFormatException e){
                System.err.println(e.getMessage() + " Is the wrong input, try again");
                return getDouble2();
            }
        }

}
