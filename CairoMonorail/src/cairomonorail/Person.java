package cairomonorail;
import java.io.Serializable;
import java.util.*;

public abstract class Person implements Information, Serializable{
    private static Scanner input=new Scanner(System.in);
    private static transient Person activePerson;
    private static int idCounter = 1;
    private int id;
    private String fname;
    private String lname;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;
    private boolean banned;

    public Person() {
        id = idCounter++;
    }
    public Person(String fname, String lname, String phoneNumber, String email, String username, String password) {
        this.fname = fname;
        this.lname = lname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.password = password;
        this.banned = false;
        id = idCounter++;
    }

    public void editAccount(){
        //this function should call a function from "Person" class account details
        //ask the user for the changed details and set those details
        System.out.println(this);
        System.out.println("1.Edit First Name");
        System.out.println("2.Edit Last Name");
        System.out.println("3.Edit Phone Number");
        System.out.println("4.Edit Email");
        System.out.println("5.Edit Password");

        int Option;
        System.out.println("Enter the Number of Information you want to Edit:");
        Option=input.nextInt();
        

        switch(Option){
            case 1: 
                System.out.println("Enter First Name:");
                setFname(input.next());
                break;
            case 2:
                System.out.println("Enter Last Name:");
                setLname(input.next());
                break;
            case 3:
                System.out.println("Enter Phone Number:");
                setPhoneNumber(input.next());
                break;
            case 4:
                System.out.println("Enter Email Address:");
                setEmail(input.next());
                break;
            case 5:
                System.out.println("Enter Password");
                setPassword(input.next());
                break;
        }
    }
    public void deleteAccount(){
        //this function should ask the user if he wants to delete his account
        //if yes it should remove the passenger object from the database
        boolean ans;
        System.out.println("Are you sure you want to delete your Account?");
        ans=input.nextBoolean();
        if(ans){
            Database.remove(this);
            logOut();
        }
    }

    public void logOut() {
        System.out.println("You have Successfuly Logged out");
    }

    public void fillInformation() {
        System.out.println("Enter first name: ");
        setFname(input.next());
        System.out.println("Enter last name: ");
        setLname(input.next());
        System.out.println("Enter phone number: ");
        setPhoneNumber(input.next());
        System.out.println("Enter E-mail: ");
        String email = input.next();
        while (Database.isExistingEmail(email)) {
            System.out.println("The email already exists please choose another email: ");
            email = input.next();
        }
        setEmail(email);
        System.out.println("Enter username: ");
        String username=input.next();
        while (Database.isExistingUsername(username)) {
            System.out.println("The username already exists please choose another username: ");
            username = input.next();
        }
        setUsername(username);
        System.out.println("Enter password: ");
        setPassword(input.next());
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Person getActivePerson() {
        return activePerson;
    }

    public static void setActivePerson(Person activePerson) {
        Person.activePerson = activePerson;
    }
        
    public boolean isBanned() {
        return banned;
    }

    public void ban() {
        setBanned(true);
    }

    public void unBan() {
        setBanned(false);
    }
    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    //this function should print on the screen all the functions 
    public abstract void displayFunctionalities();
    
    //this function should print all the information details of any person account
    @Override
    public String toString() {
        return "[ID: " + id +"First Name: " + fname +"Last Name: " + lname +"Phone Number: " + phoneNumber +"Email: " + email +"Username: " + username +"Password: " + password +"]\n";
    }
}