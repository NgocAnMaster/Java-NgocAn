package homework;

public class hw1 {
    public static void main(String[] args) {
        System.out.println("Line string");
        System.out.println("x1 line string\nx2 line string");
        hw1sub a = new hw1sub(123, "Nguyen Van A", 12, "T123");
        System.out.println(a.getId()+". "+a.getName()+" ("+a.getAge()+"), class "+a.getClasses());
        a.setClasses("T456");
        a.setId(38);
        System.out.println(a.getId()+". "+a.getName()+" ("+a.getAge()+"), class "+a.getClasses());
    }
}