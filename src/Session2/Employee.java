package Session2;

public class Employee {
    private String name;
    private int age;
    private String gender, address;

    public Employee(String name, int age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getSalary(){
        return 0;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }
    @Override
    public String toString(){
        return name + " - " + age + " years old - " + gender;
    }
}
