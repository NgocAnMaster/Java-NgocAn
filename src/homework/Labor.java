package homework;

public class Labor extends Employee {
    public Labor(String name, int age, String gender, String address) {
        super(name, age, gender, address);
    }

    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Labor(String name, int age, String gender, String address, int level) {
        super(name, age, gender, address);
        this.level = level;
    }
    public int getSalary(){
        return level * 5_000_000;
    }
    public String getEmployeeClass(){
        return "labor";
    }
}
