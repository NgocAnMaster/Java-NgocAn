public class Dog {
    public String name; // instance variable
    private int age;
    private boolean gender; // true-male, false-female
    public static int legs = 4; // Static variable
    private void sleep() {

    }

    private void eat(){

    }

    public String Bark(){
        return "Woof Woof!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Dog() {
        this.legs = legs;
    }

    public Dog(String name, int age, boolean gender, int legs) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.legs = legs;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    // Overloading
    public void eat (String food){

    }

//    public void eat(String... foods){
//        for(int i=0;i < foods.length;i++){
//            System.out.println(foods[i]);
//        }
//    }

    public void eat(String[] foods){
        for(int i=0;i < foods.length;i++){
            System.out.println(foods[i]);
        }
    }
}
