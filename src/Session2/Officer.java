package Session2;

public class Officer extends Employee{
    private int yOe;

    public Officer(String name, int age, String gender, String address, int yOe) {
        super(name, age, gender, address);
        this.yOe = yOe;
    }
    public int getSalary(){
        if(0 < yOe && yOe <= 2){
            return 8_000_000;
        }else if(2 < yOe && yOe <= 5){
            return 15_000_000;
        }else if(5 < yOe && yOe <= 10){
            return 25_000_000;
        }else if(yOe > 10){
            return 35_000_000;
        }
        return 0;
    }
}
