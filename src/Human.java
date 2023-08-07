public class Human {
    private int age;

    private String name;

//    void testChildAge(){
//        System.out.println(age);
//    }
    void testAge(int age){
        System.out.println("human age: "+this.age);
        System.out.println("pass age: "+age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
