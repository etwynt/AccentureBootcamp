import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber; // Unique account number
    private String name;          // Account holder's name
    private double balance;       // Account balance
    private String password;      // Account password
    private List<String> transactionHistory; // Transaction history

    // Constructor
    public BankAccount(String accountNumber, String name, double balance, String password) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.password = password;
        this.transactionHistory = new ArrayList<>();
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter for account holder's name
    public String getName() {
        return name;
    }


    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount, String inputPassword) {
        if (!inputPassword.equals(password)) {
            System.out.println("Invalid password. Withdrawal denied.");
            return;
        }
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Method to transfer money to another account
    public void transfer(BankAccount recipient, double amount, String inputPassword) {
        if (!inputPassword.equals(password)) {
            System.out.println("Invalid password. Transfer denied.");
            return;
        }
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.add("Transferred: " + amount + " to " + recipient.getAccountNumber());
            System.out.println("Transfer successful. Your new balance: " + balance);
        } else {
            System.out.println("Transfer failed. Insufficient funds or invalid amount.");
        }
    }

    // Getter method for balance
    public double getBalance() {
        return balance;
    }

    // Method to print balance
    public void printBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }

    // Method to print the transaction history
    public void printTransactionHistory() {
        System.out.println("Transaction History for Account: " + accountNumber);
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}
