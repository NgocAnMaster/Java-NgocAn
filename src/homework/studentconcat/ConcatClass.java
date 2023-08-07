package homework.studentconcat;

public class ConcatClass {
    private String name;
    private int age;
    private String schoolId;
    private String schName;

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

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchName() {
        return schName;
    }

    public void setSchName(String schName) {
        this.schName = schName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

    public ConcatClass(String name, int age, String schoolId, String schName, String address) {
        this.name = name;
        this.age = age;
        this.schoolId = schoolId;
        this.schName = schName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "ConcatClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", schoolId='" + schoolId + '\'' +
                ", schName='" + schName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
