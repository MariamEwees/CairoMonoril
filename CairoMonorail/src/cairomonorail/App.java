package cairomonorail;

import GUI.LogIn;
import GUI.SignUp;
import java.util.*;
public abstract class App {
    private static Scanner input=new Scanner(System.in);

    public static void main(String[] args) {
        mainScreen();
        input.close();
    }

    private static void mainScreen() {
        logIn();
    }
    //this function should take the user credentials and create an object of "loginSession"
    //and pass those credentials to its constructor
    public static void logIn(){
        new LogIn().setVisible(true);
    }
    //this function should take the passenger data and create a passenger object and add it to the DB
    public static void signUp(){
        new SignUp().setVisible(true);
    }
}
