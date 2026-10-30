package lab06.newaccount;

public class SavingAccount extends Account {
  private double minBalance = 1000.0;
  private double interestRate = 4.5;

  public SavingAccount(String accountId, String accountHolderName, double initialBalance) {
    super(accountId, accountHolderName, initialBalance);
  }

  @Override
  public void withdraw(double amount) {
    if (amount > 0 && (AccountBalance - amount) >= minBalance) {
      AccountBalance -= amount;
      transactionHistory.append("Withdraw -Rs. ").append(amount)
          .append(" | New Balance: ").append(AccountBalance).append("\n");
      System.out.println("Withdraw successfully completed.");
    } else {
      System.out.println("Withdrawal failed! Minimum balance of Rs. " + minBalance + " must be maintained.");
    }
  }

  public void calculateInterest() {
    double interest = (AccountBalance * interestRate) / 100.0;
    System.out.println("Current Balance: Rs. " + AccountBalance);
    System.out.println("Interest Rate: " + interestRate + "%");
    System.out.println("Applicable Interest: Rs. " + interest);
  }
}
