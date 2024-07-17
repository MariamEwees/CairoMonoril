package cairomonorail;
public class BankAccount {
    private double balance;
    private double minimumBalance;
    private String bankAccounNumber;
    private String password;
    
    
    public boolean checkCredit(double amount){
        //this function should check if the account has enough balance above the minimum balance
        //to pay the specified amount and should return true or false
        if(balance>=(minimumBalance+amount)){
            return true;
        } 
        return false;
    }
    
    public void payAmount(double amount) {
        //this function should call checkCredit and if it returns true it should deduct the specified amount
        //and return true;
        //(optional) we can use exception class to specify successfull and unsuccessful payment
        balance -= amount;
    }

    public void receiveAmount(double amount) {
        balance += amount;
    }
    
    public BankAccount( String bankAccounNumber, String password) {
        this.bankAccounNumber = bankAccounNumber;
        this.password = password;
    }
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public String getBankAccounNumber() {
        return bankAccounNumber;
    }

    public void setBankAccounNumber(String bankAccounNumber) {
        this.bankAccounNumber = bankAccounNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "BankAccount[" + "balance=" + balance + ", minimumBalance=" + minimumBalance + ", bankAccounNumber=" + bankAccounNumber + "]\n";
    }
    
}
