import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    private HashMap<String, Account> accounts;
    private Scanner scanner;

    public ATM() {
        accounts = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void createAccount(String accountNumber, int pin, double initialBalance) {
        accounts.put(accountNumber, new Account(accountNumber, pin, initialBalance));
        System.out.println("Account created successfully!");
        
    }

    public Account login() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Account account = accounts.get(accountNumber);
        if (account != null && account.getPin() == pin) {
            System.out.println("Login successful!");
            return account;
        } else {
            System.out.println("Invalid account number or PIN.");
            return null;
        }
    }

    public void deposit(Account account) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        account.deposit(amount);
        System.out.println("Amount deposited successfully!");
    }

    public void withdraw(Account account) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void checkBalance(Account account) {
        System.out.println("Current balance: " + account.getBalance());
    }

    public void viewTransactionHistory(Account account) {
        account.printTransactionHistory();
    }

    public void logout() {
        System.out.println("Logged out successfully.");
    }
}
