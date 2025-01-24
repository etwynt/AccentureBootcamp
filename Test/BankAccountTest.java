import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    // Test for deposit functionality
    @Test
    void testDeposit() {
        BankAccount account = new BankAccount("LV06HABA7765507223498", "Alice", 0.0, "pass123");
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), "Balance should be updated after deposit.");
    }

    // Test for withdrawal functionality
    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount("LV06HABA7765507223498", "Alice", 200.0, "pass123");
        account.withdraw(50.0, "pass123");
        assertEquals(150.0, account.getBalance(), "Balance should decrease after withdrawal.");
    }

    // Test for insufficient funds during withdrawal
    @Test
    void testInsufficientFundsWithdraw() {
        BankAccount account = new BankAccount("LV06HABA7765507223498", "Alice", 50.0, "pass123");
        account.withdraw(100.0, "pass123");
        assertEquals(50.0, account.getBalance(), "Balance should remain unchanged if withdrawal exceeds balance.");
    }

    // Test for transfer functionality
    @Test
    void testTransfer() {
        BankAccount sender = new BankAccount("LV06HABA7765507223498", "Alice", 300.0, "pass123");
        BankAccount recipient = new BankAccount("LV06HABA7765507223499", "Bob", 0.0, "secure456");

        sender.transfer(recipient, 100.0, "pass123");

        assertEquals(200.0, sender.getBalance(), "Sender's balance should decrease by transfer amount.");
        assertEquals(100.0, recipient.getBalance(), "Recipient's balance should increase by transfer amount.");
    }
}
