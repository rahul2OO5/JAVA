package lab05.account;

public class CurrentAccount extends Account {
    private double overdraftLimit = 5000.0;

    public CurrentAccount(String accountId, String accountHolderName, double initialBalance) {
        super(accountId, accountHolderName, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= -overdraftLimit) {
            balance -= amount;
            transactionHistory.append("Withdrawal: -Rs.").append(amount)
                              .append("  New Balance: Rs.").append(balance).append("\n");
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }
}
