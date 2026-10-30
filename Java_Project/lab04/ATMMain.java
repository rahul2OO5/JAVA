package lab04;

import java.util.Scanner;

class ATMMachine {
  private String accountId;
  private String accountHolderName;
  private double balance;
  private StringBuilder transactionHistory;

  private static int totalAccounts = 0;
  private static String bankName = "State Bank";

  static {
    System.out.println("Welcome to ATM");
  }

  public ATMMachine(String accountId, String accountHolderName) {
    this.accountId = accountId;
    this.accountHolderName = accountHolderName;
    this.balance = 1000.0;
    this.transactionHistory = new StringBuilder("Account Created.\n Balance: Rs. 1000.0\n");
    totalAccounts++;
  }

  public String getMaskedAccountId() {
    if (accountId.length() <= 4)
      return accountId;
    String masked = "*".repeat(accountId.length() - 4);
    return masked + accountId.substring(accountId.length() - 4);
  }

  public String getAccountHolderName() {
    return accountHolderName;
  }

  public double getBalance() {
    return balance;
  }

  public static String getBankName() {
    return bankName;
  }

  public void deposit(double amount) {
    if (amount > 0) {
      balance += amount;
      transactionHistory.append("Deposit: +Rs.").append(amount).append("  New Balance: Rs.").append(balance)
          .append("\n");
      System.out.println("Deposit successful.");
    }
  }

  public void withdraw(double amount) {
    if (amount > 0 && balance >= amount) {
      balance -= amount;
      transactionHistory.append("Withdrawal: -Rs.").append(amount).append("  New Balance: Rs.").append(balance)
          .append("\n");
      System.out.println("Withdrawal successful.");
    } else {
      System.out.println("Insufficient amount.");
    }
  }

  public void printHistory() {
    System.out.println("\n\nTransaction History\n\n");
    System.out.println(transactionHistory.toString());
  }

  public void searchHistory(String type) {
    System.out.println(" Search Results for " + type);
    String[] lines = transactionHistory.toString().split("\n");
    boolean found = false;
    for (String line : lines) {
      if (line.toLowerCase().contains(type.toLowerCase())) {
        System.out.println(line);
        found = true;
      }
    }
    if (!found)
      System.out.println("No matching transactions found.");
  }
}

public class ATMMain {
  public static void main(String[] args) {
    ATMMachine[] accounts = new ATMMachine[3];
    accounts[0] = new ATMMachine("9876543314", "Rahul Ranjan");
    accounts[1] = new ATMMachine("1234567890", "Samarth");
    accounts[2] = new ATMMachine("1122334455", "Raghav");

    Scanner sc = new Scanner(System.in);
    boolean running = true;

    while (running) {
      System.out.print("Enter Account Holder Name to search: ");
      String searchName = sc.nextLine().trim().toLowerCase();

      ATMMachine currentAccount = null;
      for (ATMMachine acc : accounts) {
        if (acc != null && acc.getAccountHolderName().toLowerCase().contains(searchName)) {
          currentAccount = acc;
          break;
        }
      }

      if (currentAccount == null) {
        System.out.println("Account not found.");
        continue;
      }

      System.out.println("Welcome, " + currentAccount.getAccountHolderName());
      System.out.println("Account: " + currentAccount.getMaskedAccountId());

      boolean accountSession = true;
      while (accountSession) {
        System.out.println("\nMenu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. View Transaction History");
        System.out.println("5. Search Transaction History");
        System.out.println("6. Switch Account");
        System.out.println("7. Exit");
        System.out.print("Select Option: ");

        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
          case 1:
            System.out.print("Enter Deposit Amount: ");
            currentAccount.deposit(sc.nextDouble());
            break;
          case 2:
            System.out.print("Enter Withdrawal Amount: ");
            currentAccount.withdraw(sc.nextDouble());
            break;
          case 3:
            System.out.println("Balance: Rs." + currentAccount.getBalance());
            break;
          case 4:
            currentAccount.printHistory();
            break;
          case 5:
            System.out.print("Enter transaction type to search");
            currentAccount.searchHistory(sc.nextLine());
            break;
          case 6:
            accountSession = false;
            break;
          case 7:
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
