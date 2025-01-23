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