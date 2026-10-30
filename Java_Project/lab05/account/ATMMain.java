package lab05.account;

import lab05.account.Account;
import lab05.account.SavingsAccount;
import lab05.account.CurrentAccount;
import java.util.Scanner;

public class ATMMain {
  public static void main(String[] args) {
    Account[] accounts = new Account[3];
    accounts[0] = new SavingsAccount("9876543314", "Rahul Ranjan", 1000.0);
    accounts[1] = new CurrentAccount("1234567890", "Samarth", 1000.0);
    accounts[2] = new SavingsAccount("1122334455", "Raghav", 2000.0);

    Scanner sc = new Scanner(System.in);
    boolean running = true;

    while (running) {
      System.out.print("Enter Account Holder Name to login (or 'exit'): ");
      String searchName = sc.nextLine().trim().toLowerCase();

      if (searchName.equals("exit"))
        break;

      Account currentAccount = null;
      for (Account acc : accounts) {
        if (acc != null && acc.getAccountHolderName().toLowerCase().contains(searchName)) {
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
        System.out.println("\nWelcome, " + currentAccount.getAccountHolderName());
        System.out.println("1. Deposit (Cash)");
        System.out.println("2. Deposit (Cheque)");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer Money");
        System.out.println("5. Check Balance & Interest (If Savings)");
        System.out.println("6. View History");
        System.out.println("7. Logout");
        System.out.print("Select Option: ");

        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
          case 1:
            System.out.print("Enter Cash Amount: ");
            currentAccount.deposit(sc.nextDouble());
            break;
          case 2:
            System.out.print("Enter Cheque Amount: ");
            currentAccount.deposit(sc.nextDouble(), "Cheque");
            break;
          case 3:
            System.out.print("Enter Withdrawal Amount: ");
            currentAccount.withdraw(sc.nextDouble());
            break;
          case 4:
            System.out.println("Available accounts to transfer:");
            for (int i = 0; i < accounts.length; i++) {
              if (accounts[i] != currentAccount) {
                System.out.println(i + ". " + accounts[i].getAccountHolderName());
              }
            }
            System.out.print("Select account index: ");
            int destIdx = sc.nextInt();
            System.out.print("Enter amount to transfer: ");
            double amt = sc.nextDouble();
            if (destIdx >= 0 && destIdx < accounts.length && accounts[destIdx] != null) {
              currentAccount.transfer(accounts[destIdx], amt);
            }
            break;
          case 5:
            System.out.println("Balance: Rs." + currentAccount.getBalance());
            if (currentAccount instanceof SavingsAccount) {
              ((SavingsAccount) currentAccount).calculateAndDisplayInterest();
            }
            break;
          case 6:
            currentAccount.printHistory();
            break;
          case 7:
            accountSession = false;
            break;
          default:
            System.out.println("Invalid Option");
        }
      }
    }
    sc.close();
  }
}
