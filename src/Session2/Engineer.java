package Session2;

public class Engineer extends Employee{
    private String major, level;

    public Engineer(String name, int age, String gender, String address, String major, String level) {
        super(name, age, gender, address);
        this.major = major;
        this.level = level;
    }
    public int getSalary(){
        int baseSalary = 0;
        if(major.equals("IT"))baseSalary = 10_000_000;
        else if(major.equals("mechanics")) baseSalary = 9_000_000;
        else if(major.equals("electronic")) baseSalary = 10_500_000;
        else if(major.equals("civil")) baseSalary = 8_000_000;
        double coef = 0;
        //coefficient Salary
        if(level.equals("Intern")) coef = 0.5;
        else if(level.equals("Fresher")) coef = 1;
        else if(level.equals("Junior")) coef = 2;
        else if(level.equals("Senior")) coef = 5;
        return (int)(baseSalary * coef);
    }
}
