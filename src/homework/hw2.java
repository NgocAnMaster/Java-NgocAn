package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class hw2 {
    public static void main(String[] args) {
        Labor labor1 = new Labor("Nguyen Van A", 28, "male", "122 Hd Road", 6);
        Engineer labor2 = new Engineer("Nguyen Thi B", 41, "female", "543 Hd Road", "electronic", "Intern");
        Officer labor3 = new Officer("Le Thi C", 34, "female", "Lo 6 Entiple Road", 15);
        Employee labor4 = new Employee("Pham Thi Nguyen D", 31, "female", "Merge 3 Street");
        Labor labor5 = new Labor("Nguyen Le E", 26, "male", "District 3", 10);
        Object[] labors = new Object[]{labor1, labor2, labor3, labor4, labor5};
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(labor1);
        employees.add(labor2);
        employees.add(labor3);
        employees.add(labor4);
        employees.add(labor5);
        Scanner inputter = new Scanner(System.in);
        int choice = 0;
        for (int i=0;choice!=3;i++){
            System.out.println("Bạn muốn chọn chức năng nào?");
            System.out.println("0. Xem danh sách");
            System.out.println("1. Thêm mới nhân viên");
            System.out.println("2. Tìm kiếm nhân viên");
            System.out.println("3. Thoat");
            do{
                System.out.print("Nhập lựa chọn: ");
                choice = inputter.nextInt();
            }while (choice<0||choice>3);
            System.out.println("Bạn đã chọn: "+choice);
            if (choice==0){
                for(int j = 0; j<employees.size(); j++){
                    System.out.println((j+1)+". "+employees.get(j).getName()+" - "+employees.get(j).getAge()+" tuổi - "+employees.get(j).getGender()+" - "+employees.get(j).getAddress()+" - "+employees.get(j).getSalary()+" đồng");
                    if(employees.get(j).getEmployeeClass()=="labor"){
                        System.out.println("\t"+employees.get(j).getEmployeeClass()+" - Trình độ "+((Labor) employees.get(j)).getLevel());
                    } else if(employees.get(j).getEmployeeClass()=="officer"){
                        System.out.println("\t"+employees.get(j).getEmployeeClass()+" - "+((Officer) employees.get(j)).getYears()+" năm kinh nghiệm");
                    } else if(employees.get(j).getEmployeeClass()=="engineer"){
                        System.out.println("\t"+employees.get(j).getEmployeeClass()+" - Chuyên ngành "+((Engineer) employees.get(j)).getMajor()+" - Trình độ "+((Engineer) employees.get(j)).getLevel());
                    }
                }
            } else if (choice==1){
                int getOcc;
                do{
                    System.out.print("Nhập chức vụ của nhân viên (1. Công nhân, 2. Kỹ sư, 3. Nhân viên văn phòng, 4. Không): ");
                    getOcc = inputter.nextInt();
                }while (getOcc<1||getOcc>4);
                System.out.println("Bạn đã chọn: "+getOcc);
                System.out.print("Vui lòng nhập tên: ");
                String empName = inputter.nextLine();
                System.out.print("Vui lòng nhập tuổi: ");
                int empAge = inputter.nextInt();
                int empGend;
                do {
                    System.out.print("Vui lòng nhập giới tính (0 = Nam, 1 = Nữ, 2 = Khác): ");
                    empGend = inputter.nextInt();
                }while (empGend<0||empGend>2);
                System.out.print("Vui lòng nhập địa chỉ: ");
                String empAdd = inputter.nextLine();
                String empGendName;
                empGendName = getGender(empGend);
                if(getOcc==1){
                    System.out.println("Vui lòng nhập level (1-10): ");
                    int empLevel = inputter.nextInt();
                    employees.add(new Labor(empName, empAge, empGendName, empAdd, empLevel));
                } else if (getOcc==2) {
                    System.out.print("Vui lòng nhập chuyên ngành (IT, mechanics, electronic, civil): ");
                    String empMajor = inputter.nextLine();
                    System.out.print("Vui lòng nhập cấp bậc (Intern, Fresher, Junior, Senior): ");
                    String empLevel = inputter.nextLine();
                    employees.add(new Engineer(empName, empAge, empGendName, empAdd, empMajor, empLevel));
                } else if (getOcc==3) {
                    System.out.print("Vui lòng nhập số năm kinh nghiệm: ");
                    int empYears = inputter.nextInt();
                    employees.add(new Officer(empName, empAge, empGendName, empAdd, empYears));
                } else {
                    employees.add(new Employee(empName, empAge, empGendName, empAdd));
                }
                System.out.println("Kết quả đã được lưu thành công!");
            } else if (choice==2) {
                System.out.print("Nhập từ khoá để tìm kiếm: ");
                inputter.nextLine();
                String findingKey = inputter.nextLine();
                System.out.println("-------------------------------");
                System.out.println("Các kết quả tìm được:");
                int resCount = 0;
                for (int j = 0; j < employees.size(); j++) {
                    if (employees.get(j).getName().contains(findingKey)) {
                        resCount++;
                        System.out.println(resCount+". "+employees.get(j).getName()+" - "+employees.get(j).getAge()+" tuổi - "+employees.get(j).getGender()+" - "+employees.get(j).getAddress()+" - "+employees.get(j).getSalary()+" đồng");
                        if(employees.get(j).getEmployeeClass()=="labor"){
                            System.out.println("\t"+employees.get(j).getEmployeeClass()+" - Trình độ "+((Labor) employees.get(j)).getLevel());
                        } else if(employees.get(j).getEmployeeClass()=="officer"){
                            System.out.println("\t"+employees.get(j).getEmployeeClass()+" - "+((Officer) employees.get(j)).getYears()+" năm kinh nghiệm");
                        } else if(employees.get(j).getEmployeeClass()=="engineer"){
                            System.out.println("\t"+employees.get(j).getEmployeeClass()+" - Chuyên ngành "+((Engineer) employees.get(j)).getMajor()+" - Trình độ "+((Engineer) employees.get(j)).getLevel());
                        }
                    }
                }
                if (resCount==0){
                    System.out.println("Không có kết quả");
                } else {
                    System.out.println("("+resCount+" kết quả)");
                }
                System.out.println("------------------------------");
            }
        }
    }

//    public long laborSalary(Labor lob1){
//        long salary = lob1.getLevel()*5000000L;
//        return salary;
//    }
//
//    public long engineerSalary(Engineer eng1){
//        long salary = 0, majorSal = 0;
//        double multiLevel = 0;
//        if(eng1.getMajor() == "IT") {
//            majorSal = 10000000;
//        } else if (eng1.getMajor() == "mechanics") {
//            majorSal = 9000000;
//        } else if (eng1.getMajor() == "electronic") {
//            majorSal = 10500000;
//        } else if (eng1.getMajor() == "civil") {
//            majorSal = 8000000;
//        }
//        if(eng1.getLevel() == "intern") {
//            multiLevel = 0.5;
//        } else if (eng1.getLevel() == "fresher") {
//            multiLevel = 1;
//        } else if (eng1.getLevel() == "junior") {
//            multiLevel = 2;
//        } else if (eng1.getLevel() == "senior") {
//            multiLevel = 5;
//        }
//        salary = (long) (majorSal*multiLevel);
//        return salary;
//    }
//
//    public long officerSalary(Officer ofc){
//        long salary = 0;
//        if(ofc.getYears()>0&&ofc.getYears()<=2){
//            salary = 8000000;
//        } else if (ofc.getYears()>2&&ofc.getYears()<=5) {
//            salary = 15000000;
//        } else if (ofc.getYears()>5&&ofc.getYears()<=10) {
//            salary = 25000000;
//        } else if (ofc.getYears()>10) {
//            salary = 35000000;
//        }
//        return salary;
//    }
//
//    public long employeeSalary(){
//        return 0;
//    }

//    public static Object[] appendToArray(Object[] array, Object value) {
//        Object[] result = Arrays.copyOf(array, array.length + 1);
//        result[result.length - 1] = value;
//        return result;
//    }

    public static String getGender(int Gend) {
        if (Gend==0){
            return "male";
        } else if (Gend==1) {
            return "female";
        } else if (Gend==2) {
            return "other";
        }
        return null;
    }
}
