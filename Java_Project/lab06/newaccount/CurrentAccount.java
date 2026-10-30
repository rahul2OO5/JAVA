package lab06.newaccount;

public class CurrentAccount extends Account {
  private double overDrawLimit = 40000.0;

  public CurrentAccount(String accountId, String accountHolderName, double initialBalance) {
    super(accountId, accountHolderName, initialBalance);
  }

  @Override
  public void withdraw(double amount) {
    if (amount > 0 && (AccountBalance - amount) >= -overDrawLimit) {
      AccountBalance -= amount;
      transactionHistory.append("Withdraw -Rs. ").append(amount)
          .append(" | New Balance: ").append(AccountBalance).append("\n");
      System.out.println("Withdraw successfully completed.");
    } else {
      System.out.println("Withdrawal failed! Exceeds overdraft limit of Rs. " + overDrawLimit);
    }
  }
}
