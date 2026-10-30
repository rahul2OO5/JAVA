package lab06.newaccount;

public abstract class Account {
  protected String accountId;
  protected String accountHolderName;
  protected double AccountBalance;
  protected StringBuilder transactionHistory;

  public Account(String accountId, String accountHolderName, double initialBalance) {
    this.accountId = accountId.trim();
    this.accountHolderName = accountHolderName.trim();
    this.AccountBalance = initialBalance;
    this.transactionHistory = new StringBuilder("Account Created.\nInitial Balance: Rs. " + initialBalance + "\n");
  }

  public String getAccountId() {
    return accountId;
  }

  public String getMaskedId() {
    if (accountId.length() <= 4)
      return accountId;
    return "*".repeat(accountId.length() - 4) + accountId.substring(accountId.length() - 4);
  }

  public String getAccountHolderName() {
    return accountHolderName;
  }

  public double getBalance() {
    return AccountBalance;
  }

  public void deposit(double amount) {
    deposit(amount, "Cash");
  }

  public void deposit(double amount, String mode) {
    if (amount > 0) {
      AccountBalance += amount;
      transactionHistory.append("Deposit (").append(mode).append(") +Rs. ").append(amount)
          .append(" | New Balance: ").append(AccountBalance).append("\n");
      System.out.println("Deposited by " + mode);
    } else {
      System.out.println("Invalid deposit amount.");
    }
  }

  public abstract void withdraw(double amount);

  public void transfer(Account destination, double amount) {
    double balanceBeforeTransfer = this.AccountBalance;
    this.withdraw(amount);

    if (this.AccountBalance < balanceBeforeTransfer) {
      destination.deposit(amount, "Transfer from " + this.getMaskedId());
      transactionHistory.append("Transfer Out -Rs. ").append(amount)
          .append(" to ").append(destination.getMaskedId())
          .append(" | New Balance: ").append(AccountBalance).append("\n");
      System.out.println("Transfer successfully completed.");
    } else {
      System.out.println("Transfer Failed.");
    }
  }

  public void displayHistory() {
    System.out.println("\nTransaction History for " + accountHolderName + " (" + getMaskedId() + "):");
    System.out.println(transactionHistory.toString());
  }

  public void searchHistory(String type) {
    String key = type.trim().toLowerCase();
    String[] lines = transactionHistory.toString().split("\n");
    boolean found = false;

    System.out.println("\nMatching transactions for '" + type.trim() + "':");
    for (String line : lines) {
      if (line.toLowerCase().contains(key)) {
        System.out.println(line);
        found = true;
      }
    }
    if (!found) {
      System.out.println("No matching transactions found.");
    }
  }

  public void displayAccountInfo() {
    System.out.println(
        "Account No: " + getMaskedId() + " | Holder: " + accountHolderName + " | Balance: Rs. " + AccountBalance);
  }
}
