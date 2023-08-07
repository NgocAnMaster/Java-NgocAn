package banking;

public class CurrentAccount implements Account {
    private double balance = 0;

    @Override
    public boolean deposit(double amount, int month, int year, int term) {
        balance += amount;
        return true;
    }

    @Override
    public double withdraw(double amount, int month, int year) {
        if (amount > balance) {
            return 0;
        }
        balance -= amount;
        return amount;
    }

    @Override
    public double calculateInterest() {
        return 0;
    }

    @Override
    public double viewBalance() {
        return balance;
    }
}
