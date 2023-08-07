package banking;

public class Bank {
    public static void main(String[] args) {
        Account account = new SavingAccount();
        account.deposit(10_000_000, 1, 2022, 8);
        double withdrawAmount = account.withdraw(0, 7, 2023);
        System.out.println(withdrawAmount);
    }
}
