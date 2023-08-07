package banking;

public class SavingAccount implements Account {
    private double balance = 0;
    private int depositMonth;
    private int depositYear;
    private int term;

    @Override
    public boolean deposit(double amount, int month, int year, int term) {
        if (balance > 0) {
            return false;
        }
        if (term < 0 || term > 36) {
            return false;
        }
        this.balance += amount;
        this.depositMonth = month;
        this.depositYear = year;
        this.term = term;
        return true;
    }

    @Override
    public double withdraw(double amount, int month, int year) {
        int totalMonth = 12 * (year - this.depositYear) + (month - this.depositMonth);
        if (totalMonth < term) {
            return 0;
        }
        double withdrawlAmount = balance + balance * calculateInterest() * term / 12;
        balance = 0;
        return withdrawlAmount;
    }

    @Override
    public double calculateInterest() {
        if (term <= 6) {
            return 0.06;
        } else if (term <= 12) {
            return 0.07;
        } else {
            return 0.08;
        }
    }

    @Override
    public double viewBalance() {
        return balance;
    }
}
