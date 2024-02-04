import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private String accountNumber;
    private double balance;
    private double PIN;
    private ArrayList<String> transactionHistory;

    public ATM(String accountNumber, double balance, double PIN){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.PIN = PIN;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount){
        if (amount < 0) {
            System.out.println("Error: Do not enter a negative amount");
        } else {
            balance += amount;
            // Record the deposit in transaction history
            transactionHistory.add("Deposit: +" + amount);
            System.out.println("Deposit: " + amount);
            System.out.println("New Balance: " + balance);
        }
    }

    // Method to handle withdrawal transactions
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Error: This amount is greater than the balance");
        } else {
            balance -= amount;
            // Record the withdrawal in transaction history
            transactionHistory.add("Withdrawal: -" + amount);
            System.out.println("Withdrawal: " + amount);
            System.out.println("New Balance: " + balance);
        }
    }

    // Getter method to retrieve the current balance
    public double getBalance() {
        return balance;
    }

    // Getter method to retrieve the account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Method to display the transaction history
    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Method to verify the PIN entered by the user
    public boolean verifyPin(double newPin) {
        return newPin == PIN;
    }

    // Method to display the menu options
    public void menu() {
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Get Balance");
        System.out.println("4. Transaction History");
        System.out.println("5. Exit");
    }

    // Method to handle user choices and perform corresponding actions
    public void check() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            menu();
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter an amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter an amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: " + getBalance());
                    break;
                case 4:
                    displayTransactionHistory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        } while (choice != 5);
    }


    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your account number: ");
        String accNumber = scanner.next();
        System.out.println("Enter your PIN: ");
        double pin = scanner.nextDouble();

        // Create a BankAccount object
        BankAccount account = new BankAccount(accNumber, 100, 1111);

        // Verify the entered PIN before allowing access to the account
        if (account.verifyPin(pin)) {
            // If PIN is correct, allow the user to interact with the account
            account.check();
        } else {
            // If PIN is incorrect, notify the user and exit
            System.out.println("Incorrect PIN. Exiting...");
        }
    }



}
