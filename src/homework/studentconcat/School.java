package homework.studentconcat;

public class School {
    private String schoolId;
    private String schName;
    private String address;

    @Override
    public String toString() {
        return "School{" +
                "schoolId='" + schoolId + '\'' +
                ", schName='" + schName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public School(String schoolId, String schName, String address) {
        this.schoolId = schoolId;
        this.schName = schName;
        this.address = address;
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
}
