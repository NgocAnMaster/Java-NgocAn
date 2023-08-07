package BookDemo;

public class Engineer extends Employee{
    @Override
    public double getSalary() {
        return 0;
    }
}

//2. Write a Java program to create a Animal interface
// with a method called bark()
// that takes no arguments and returns void. Create a Dog class that implements
// Animal and overrides bark() to print "Dog is barking".

//4. Write a Java programming to create a banking system with
// three classes - Bank, Account, SavingsAccount, and CurrentAccount.
// The bank should have a list of accounts and methods for adding them.
// Accounts should be an interface with methods to deposit, withdraw,
// calculate interest,
// and view balances.
// SavingsAccount and CurrentAccount should implement the Account interface and
// have their own unique methods.