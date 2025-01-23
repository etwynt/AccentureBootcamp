public class BankAccount {
    // Property to store the balance
    private double balance;

    // Default constructor (empty)
    public BankAccount() {
        this.balance = 0.0;
    }

    // Constructor with balance parameter
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Method to deposit an amount into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw an amount from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    // Method to print the current balance
    public void printBalance() {
        System.out.println("Current balance: " + balance);
    }

    // Method to transfer balance to another BankAccount
    public void transfer(BankAccount recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            System.out.println("Transfer successful. Your new balance: " + balance);
        } else {
            System.out.println("Transfer failed. Insufficient funds or invalid amount.");
        }
    }
}
