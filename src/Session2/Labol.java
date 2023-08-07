package Session2;
import java.util.Scanner;
public class Labol extends Employee{
    private int level;

    public Labol(String name, int age, String gender, String address, int level) {
        super(name, age, gender, address);
        this.level = level;
    }

    public int getSalary(){
        return level * 5_000_000;
    }
}
