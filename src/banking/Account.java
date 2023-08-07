package banking;

public interface Account {
    boolean deposit(double amount, int month, int year, int term);
    double withdraw(double amount, int month, int year);
    double calculateInterest();
    double viewBalance();
}
