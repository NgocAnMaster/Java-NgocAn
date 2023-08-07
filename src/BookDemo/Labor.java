package BookDemo;

public class Labor extends Employee{
    private int level;
    @Override
    public double getSalary() {
        return level * 5000000;
    }
}
