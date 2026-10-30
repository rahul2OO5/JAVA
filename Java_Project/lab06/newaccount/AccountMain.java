package lab06.newaccount;

import java.util.Scanner;

public class AccountMain {

  private static Account findAccount(Account[] accounts, String id) {
    id = id.trim();
    for (Account acc : accounts) {
      if (acc.getAccountId().equalsIgnoreCase(id) || acc.getMaskedId().endsWith(id)) {
        return acc;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Account[] accounts = new Account[4];
    accounts[0] = new SavingAccount("10230003314", "Rahul Ranjan", 15000.0);
    accounts[1] = new SavingAccount("47630004521", "Raghav Sharma", 8000.0);
    accounts[2] = new CurrentAccount("12220007890", "Samarth Verma", 25000.0);
    accounts[3] = new CurrentAccount("00320009912", "Ankur Singh", 10000.0);

    while (true) {
      System.out.println("ATM Machine Menu");
      System.out.println("1. Display All Accounts (Masked ID)");
      System.out.println("2. Search Account by Holder Name");
      System.out.println("3. Deposit (Cash - Amount Only)");
      System.out.println("4. Deposit (With Mode - Cash/Cheque)");
      System.out.println("5. Withdraw Money");
      System.out.println("6. Check Balance");
      System.out.println("7. Calculate Interest (Savings Account)");
      System.out.println("8. Transfer Money Between Accounts");
      System.out.println("9. View Transaction History");
      System.out.println("10. Search Transaction History");
      System.out.println("0. Exit");
      System.out.print("Enter choice: ");

      int choice = sc.nextInt();
      sc.nextLine();

      switch (choice) {
        case 1:
          for (Account acc : accounts) {
            String type = (acc instanceof SavingAccount) ? "[Savings] " : "[Current] ";
            System.out.print(type);
            acc.displayAccountInfo();
          }
          break;

        case 2:
          System.out.print("Enter name to search: ");
          String keyword = sc.nextLine().trim().toLowerCase();
          boolean found = false;
          for (Account acc : accounts) {
            if (acc.getAccountHolderName().toLowerCase().contains(keyword)) {
              acc.displayAccountInfo();
              found = true;
            }
          }
          if (!found) {
            System.out.println("No account found matching name.");
          }
          break;

        case 3:
          System.out.print("Enter Account ID (or last 4 digits): ");
          Account depAcc1 = findAccount(accounts, sc.nextLine());
          if (depAcc1 == null) {
            System.out.println("Account not found.");
            break;
          }
          System.out.print("Enter amount to deposit: ");
          double amt1 = sc.nextDouble();
          sc.nextLine();
          depAcc1.deposit(amt1);
          break;

        case 4:
          System.out.print("Enter Account ID (or last 4 digits): ");
          Account depAcc2 = findAccount(accounts, sc.nextLine());
          if (depAcc2 == null) {
            System.out.println("Account not found.");
            break;
          }
          System.out.print("Enter amount to deposit: ");
          double amt2 = sc.nextDouble();
          sc.nextLine();
          System.out.print("Enter mode (Cash/Cheque): ");
          String mode = sc.nextLine().trim();
          depAcc2.deposit(amt2, mode);
          break;

        case 5:
          System.out.print("Enter Account ID (or last 4 digits): ");
          Account wAcc = findAccount(accounts, sc.nextLine());
          if (wAcc == null) {
            System.out.println("Account not found.");
            break;
          }
          System.out.print("Enter amount to withdraw: ");
          double wAmt = sc.nextDouble();
          sc.nextLine();
          wAcc.withdraw(wAmt);
          break;

        case 6:
          System.out.print("Enter Account ID (or last 4 digits): ");
          Account bAcc = findAccount(accounts, sc.nextLine());
          if (bAcc == null) {
            System.out.println("Account not found.");
          } else {
            System.out.println("Current Balance: Rs. " + bAcc.getBalance());
          }
          break;

        case 7:
          System.out.print("Enter Account ID (or last 4 digits): ");
          Account iAcc = findAccount(accounts, sc.nextLine());
          if (iAcc == null) {
            System.out.println("Account not found.");
          } else if (iAcc instanceof SavingAccount) {
            ((SavingAccount) iAcc).calculateInterest();
          } else {
            System.out.println("Interest calculation is only applicable to Savings Accounts.");
          }
          break;

        case 8:
          System.out.print("Enter Source Account ID (or last 4 digits): ");
          Account src = findAccount(accounts, sc.nextLine());
          System.out.print("Enter Destination Account ID (or last 4 digits): ");
          Account dest = findAccount(accounts, sc.nextLine());

          if (src == null || dest == null) {
            System.out.println("Invalid source or destination account.");
            break;
          }
          if (src == dest) {
            System.out.println("Cannot transfer to the same account.");
            break;
          }
          System.out.print("Enter amount to transfer: ");
          double tAmt = sc.nextDouble();
          sc.nextLine();
          src.transfer(dest, tAmt);
          break;

        case 9:
          System.out.print("Enter Account ID (or last 4 digits): ");
          Account hAcc = findAccount(accounts, sc.nextLine());
          if (hAcc == null) {
            System.out.println("Account not found.");
          } else {
            hAcc.displayHistory();
          }
          break;

        case 10:
          System.out.print("Enter Account ID (or last 4 digits): ");
          Account sAcc = findAccount(accounts, sc.nextLine());
          if (sAcc == null) {
            System.out.println("Account not found.");
            break;
          }
          System.out.print("Enter transaction type to search (Deposit/Withdraw/Transfer): ");
          sAcc.searchHistory(sc.nextLine());
          break;

        case 0:
          sc.close();
          return;

        default:
          System.out.println("Invalid choice.");
      }
    }
  }
}
