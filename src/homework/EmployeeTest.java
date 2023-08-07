package homework;

enum Occupation{
    ENGINEER,
    LABOR,
    OFFICER,
    EMPLOYEE
}
public class EmployeeTest {
    Occupation occ;

    public EmployeeTest(Occupation occ) {
        this.occ = occ;
    }

    public Occupation getOcc() {
        return occ;
    }

    public void setOcc(Occupation occ) {
        this.occ = occ;
    }
}
