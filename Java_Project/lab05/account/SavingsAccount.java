package lab05.account;

public class SavingsAccount extends Account {
    private double minBalance = 500.0;
    private double interestRate = 0.04;

    public SavingsAccount(String accountId, String accountHolderName, double initialBalance) {
        super(accountId, accountHolderName, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= minBalance) {
            balance -= amount;
            transactionHistory.append("Withdrawal: -Rs.").append(amount)
                              .append("  New Balance: Rs.").append(balance).append("\n");
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds or minimum balance limit reached.");
        }
    }

    public void calculateAndDisplayInterest() {
        double interest = balance * interestRate;
        System.out.println("Current Interest Applicable: Rs." + interest);
    }
}
