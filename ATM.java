import java.util.Scanner;

// Class representing the user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize the balance
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false; // Insufficient funds
        }
        balance -= amount;
        return true;
    }

    // Method to check the account balance
    public double checkBalance() {
        return balance;
    }
}

// Class representing the ATM machine
public class ATM {
    private BankAccount account;

    // Constructor to initialize the ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display the ATM menu and handle user input
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double amount;

        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to withdraw: $");
                    amount = scanner.nextDouble();
                    if (account.withdraw(amount)) {
                        System.out.println("Withdrawal successful. Remaining balance: $" + account.checkBalance());
                    } else {
                        System.out.println("Insufficient funds. Withdrawal failed.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: $");
                    amount = scanner.nextDouble();
                    account.deposit(amount);
                    System.out.println("Deposit successful. New balance: $" + account.checkBalance());
                    break;
                case 3:
                    System.out.println("Your current balance is: $" + account.checkBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void main(String[] args) {
        // Create a bank account with initial balance of $1000
        BankAccount account = new BankAccount(1000);
        // Create an ATM object with the bank account
        ATM atm = new ATM(account);
        // Display the ATM menu
        atm.displayMenu();
    }
}
