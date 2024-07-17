package cairomonorail;
import java.util.*;

public class Passenger extends Person {
    private static Scanner input=new Scanner(System.in);
    private BankAccount bankAccount;
    private ArrayList<Ticket>bookedTicketsList;

    public Passenger() {
        Database.add(this);
    }

    public Passenger(String fname, String lname, String phoneNumber, String email, String username, String password) {
        super(fname, lname, phoneNumber, email, username, password);
        Database.add(this);
    }
    public void createBankAccount(){
        System.out.println("Enter Your Bank Account Number:");
        String bankNumber=input.next();
        System.out.println("Enter Your Bank Account Password:");
        String bankPassword=input.next();
        bankAccount=new BankAccount(bankNumber,bankPassword);
    }

    public void bookTicket(){
        
    }
    public void editTicket(){
        
    }
    
    public void deleteTicket(){
        //this function should present the user with list of all of his booked tickets (calling displayBookedTickets)
        //ask him for the ticket he wants to delete and delete it
        System.out.println(bookedTicketsList);
        System.out.println("Enter the ticket ID you want to delete:");
         
        Ticket removeTicket=Database.getTicketById(input.nextInt());
        bookedTicketsList.remove( removeTicket);
        Database.remove(removeTicket);
    }
    
    public void removeTicket(Ticket t){
        bookedTicketsList.remove( t);
        Database.remove(t);
    }
    public void displayBookedTickets(){
        //this function should display all booked tickets from the bookedTicketsList
        System.out.println(bookedTicketsList);
    }
    
    @Override
    public void displayFunctionalities(){
        //this function should output all the functionalities of passenger
        //receive selection from the user and call the respective function
        int Option ;
        do{
        System.out.println("Functions avaliable for the passenger:");
        System.out.println("1.Book Ticket");
        System.out.println("2.Edit Ticket");
        System.out.println("3.Delete Ticket");
        System.out.println("4.Edit Account");
        System.out.println("5.Delete Account");
        System.out.println("6.Display Booked Tickets");
        System.out.println("0.Log out");
        
        System.out.println("Enter a valid Option:\n");
        Option = input.nextInt();
        
        switch(Option){
            case 1:
                bookTicket();
                break;
            case 2:
                editTicket();
                break;
            case 3:
                deleteTicket();
                break;
            case 4:
                editAccount();
                break;
            case 5:
                deleteAccount();
                break;
            case 6:
                displayBookedTickets();
                break;
            case 0:logOut();
                break;
        }
        }while(Option!=0);
       
    }

    public void pay(double amount) {
        //this function should check the bank account balance if it has sufficient money 
        //to pay the specified amount and deduct those money from the bankaccount
        //by calling the appropriate functions in bankaccount class
        if (bankAccount.checkCredit(amount)) {
            bankAccount.payAmount(amount);
            System.out.println("Payment Successful!!");
        } else {
            System.out.println("Insuffuent Amount avaliable in your Account");
        }
    }

    public void receive(double amount) {
        bankAccount.receiveAmount(amount);
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    
}