import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize bank accounts with names
        BankAccount account1 = new BankAccount("LV06HABA7765507223498", "Alice", 500.0, "pass123");
        BankAccount account2 = new BankAccount("LV06HABA7765507223499", "Bob", 1000.0, "secure456");

        BankAccount[] accounts = {account1, account2};

        System.out.println("Welcome to the Bank!");

        BankAccount currentAccount = null;

        // Account selection loop
        while (currentAccount == null) {
            System.out.println("\nPlease enter your account number:");
            String inputAccountNumber = scanner.next();

            for (BankAccount account : accounts) {
                if (account.getAccountNumber().equals(inputAccountNumber)) {
                    currentAccount = account;
                    break;
                }
            }

            if (currentAccount == null) {
                System.out.println("Account number not found. Please try again.");
            }
        }

        // Greet the user by name
        System.out.println("Welcome to your account, " + currentAccount.getName() + "! You can now perform transactions.");

        // Main program loop
        while (true) {
            System.out.println("\nChoose an action: ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Print Balance");
            System.out.println("4. Transfer");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Deposit
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    currentAccount.deposit(depositAmount);
                    break;

                case 2: // Withdraw
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.print("Enter password: ");
                    String withdrawPassword = scanner.next();
                    currentAccount.withdraw(withdrawAmount, withdrawPassword);
                    break;

                case 3: // Print balance
                    currentAccount.printBalance();
                    break;

                case 4: // Transfer
                    System.out.print("Enter recipient account number: ");
                    String recipientAccountNumber = scanner.next();
                    BankAccount recipientAccount = null;

                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber().equals(recipientAccountNumber)) {
                            recipientAccount = account;
                            break;
                        }
                    }

                    if (recipientAccount == null) {
                        System.out.println("Recipient account not found.");
                    } else {
                        System.out.print("Enter transfer amount: ");
                        double transferAmount = scanner.nextDouble();
                        System.out.print("Enter password: ");
                        String transferPassword = scanner.next();
                        currentAccount.transfer(recipientAccount, transferAmount, transferPassword);
                    }
                    break;

                case 5: // View transaction history
                    currentAccount.printTransactionHistory();
                    break;

                case 6: // Exit
                    System.out.println("Exiting the banking program. Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
