package homework;

public class Officer extends Employee{
    public Officer(String name, int age, String gender, String address) {
        super(name, age, gender, address);
    }

    private int years;

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public Officer(String name, int age, String gender, String address, int years) {
        super(name, age, gender, address);
        this.years = years;
    }
    public int getSalary(){
        if(0 < years && years <= 2){
            return 8_000_000;
        }else if(2 < years && years <= 5){
            return 15_000_000;
        }else if(5 < years && years <= 10){
            return 25_000_000;
        }else if(years > 10){
            return 35_000_000;
        }
        return 0;
    }
    public String getEmployeeClass(){
        return "officer";
    }
}
