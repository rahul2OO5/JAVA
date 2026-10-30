package lab05.account;

public abstract class Account {
    protected String accountId;
    protected String accountHolderName;
    protected double balance;
    protected StringBuilder transactionHistory;

    public Account(String accountId, String accountHolderName, double initialBalance) {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new StringBuilder("Account Created.\n Initial Balance: Rs. " + initialBalance + "\n");
    }

    public String getMaskedAccountId() {
        if (accountId.length() <= 4) return accountId;
        return "*".repeat(accountId.length() - 4) + accountId.substring(accountId.length() - 4);
    }

    public String getAccountHolderName() { return accountHolderName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        deposit(amount, "Cash");
    }

    public void deposit(double amount, String mode) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.append("Deposit (").append(mode).append("): +Rs.").append(amount)
                              .append("  New Balance: Rs.").append(balance).append("\n");
            System.out.println("Deposit successful via " + mode + ".");
        }
    }

    public abstract void withdraw(double amount);

    public void transfer(Account destination, double amount) {
        double balanceBefore = this.balance;
        this.withdraw(amount); 
        
        if (this.balance < balanceBefore) { 
            destination.deposit(amount, "Transfer from " + this.accountId);
            transactionHistory.append("Transfer Out: -Rs.").append(amount)
                              .append(" to ").append(destination.getMaskedAccountId())
                              .append("  New Balance: Rs.").append(balance).append("\n");
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed.");
        }
    }

    public void printHistory() {
        System.out.println("\nTransaction History for " + accountHolderName + "\n" + transactionHistory.toString());
    }
}
