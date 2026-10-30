package lab03;
import java.util.Scanner;

class ATMMachine {
    private int accountId;
    private double balance;
    private static int totalAccounts = 0;
    private static String bankName = "State Bank";

    static {
        System.out.println("ATM system has been initialized.");
    }

    public ATMMachine(int accountId) {
        this.accountId = accountId;
        this.balance = 1000.0;
        totalAccounts++;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static String getBankName() {
        return bankName;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }
}

public class ATMMain {
    public static void main(String[] args) {
        ATMMachine[] accounts = new ATMMachine[5];
        for (int i = 0; i < 5; i++) {
            accounts[i] = new ATMMachine(i + 1);
        }

        System.out.println("Total accounts created: " + ATMMachine.getTotalAccounts());

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Enter Account id: ");
            int id = sc.nextInt();
            
            ATMMachine currentAccount = null;
            for (ATMMachine acc : accounts) {
                if (acc.getAccountId() == id) {
                    currentAccount = acc;
                    break;
                }
            }

            if (currentAccount == null) {
                System.out.println("Account not found.");
                continue;
            }

            boolean accountSession = true;
            while (accountSession) {
                System.out.println("Bank Name: " + ATMMachine.getBankName());
                System.out.println("Menu:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Enter another account");
                System.out.println("5. Exit");
                System.out.print("Select Option number: ");
                
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter Amount to deposit: ");
                        double depAmount = sc.nextDouble();
                        currentAccount.deposit(depAmount);
                        break;
                    case 2:
                        System.out.print("Enter Amount to withdraw: ");
                        double withAmount = sc.nextDouble();
                        currentAccount.withdraw(withAmount);
                        break;
                    case 3:
                        System.out.println("Balance: Rs." + currentAccount.getBalance());
                        break;
                    case 4:
                        accountSession = false;
                        break;
                    case 5:
                        accountSession = false;
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid Option");
                }
            }
        }
        sc.close();
    }
}