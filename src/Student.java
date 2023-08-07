import java.util.Objects;

public class Student {
    private String name;
    private String className;
    private void getClassName(){}
    private int age;

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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", age=" + age +
                '}';
    }

    public void setClassName(String className) {
        this.className = className;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return age == student.age && Objects.equals(name, student.name) && Objects.equals(className, student.className);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, className, age);
//    }
}
