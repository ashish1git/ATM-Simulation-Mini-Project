import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.createAccount("8104287477", 1234, 100);  // Pre-created account for testing

        Account currentAccount = null;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (currentAccount == null) {
                currentAccount = atm.login();
            }

            if (currentAccount != null) {
                System.out.println("\n--- ATM Menu ---");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. View Transaction History");
                System.out.println("5. Logout");
                System.out.print("Select an option: ");
                int option = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (option) {
                    case 1:
                        atm.deposit(currentAccount);
                        break;
                    case 2:
                        atm.withdraw(currentAccount);
                        break;
                    case 3:
                        atm.checkBalance(currentAccount);
                        break;
                    case 4:
                        atm.viewTransactionHistory(currentAccount);
                        break;
                    case 5:
                        atm.logout();
                        currentAccount = null;
                        break;
                    default:
                        System.out.println("Invalid option.");
                        break;
                }
            }
        }
    }
}
