import java.util.Scanner;

public class Contacts {
    private String Firstname;
    private String LastName;
    private int phoneNum;
    Scanner scanner = new Scanner(System.in);
    //Set
    public void setFirstname(String name){
        this.Firstname = name;
    }
    public void setLastName(String last){
        this.LastName = last;
    }
    public void setPhoneNum (int num){
            this.phoneNum = num;
    }

    //Get
    public String getFirstname(){
        return Firstname;
    }
    public String getLastName(){
        return LastName;
    }
    public int getPhoneNum (){
        return phoneNum;
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
}
