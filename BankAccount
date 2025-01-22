BankAccount.java

```java

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
```

Main.java

```java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create two bank accounts for testing
        BankAccount account1 = new BankAccount();  // Account 1 starts with 0 balance
        BankAccount account2 = new BankAccount(100.0);  // Account 2 starts with 100 balance

        // Example of interacting with the user
        System.out.println("Welcome to the Banking Program!");

        while (true) {
            System.out.println("\nChoose an action: ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Print Balance");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");

            // Get user's choice
            int choice = scanner.nextInt();

            // Switch statement for handling actions based on user's choice
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account1.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account1.withdraw(withdrawAmount);
                    break;
                case 3:
                    account1.printBalance();
                    break;
                case 4:
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    account1.transfer(account2, transferAmount);
                    break;
                case 5:
                    System.out.println("Exiting. Thank you for using the banking program!");
                    scanner.close();
                    return; // Exiting the program
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
```
