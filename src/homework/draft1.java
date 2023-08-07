package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class draft1 {
    public static void main(String[] args) {
        Labor labor1 = new Labor("Nguyen Van A", 28, "male", "122 Hd Road", 6);
        Engineer labor2 = new Engineer("Nguyen Thi B", 41, "female", "543 Hd Road", "IT", "fresher");
        Officer labor3 = new Officer("Le Thi C", 34, "female", "Lo 6 Entiple Road", 15);
        Employee labor4 = new Employee("Pham Thi Nguyen D", 31, "female", "Merge 3 Street");
        Labor labor5 = new Labor("Nguyen Le E", 26, "male", "District 3");
        Object[] labors = new Object[]{labor1, labor2, labor3, labor4, labor5};
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(labor1);
        employees.add(labor2);
        employees.add(labor3);
        employees.add(labor4);
        employees.add(labor5);
        for(int j = 0; j<employees.size(); j++){
            System.out.println((j+1)+". "+employees.get(j).getName()+" - "+employees.get(j).getAge()+" tuổi - "+employees.get(j).getGender()+" - "+employees.get(j).getAddress()+" - "+employees.get(j).getSalary()+" đồng");
            System.out.println(employees.get(j));
        }

//        Scanner inputter = new Scanner(System.in);
//        System.out.print("Vui lòng nhập chuyên ngành (IT, mechanics, electronic, civil): ");
//        String empMajor = inputter.nextLine();
//        System.out.print("Vui lòng nhập cấp bậc (Intern, Fresher, Junior, Senior): ");
//        String empLevel = inputter.nextLine();
//        System.out.println(empMajor+" - "+empLevel);
//        EngineerMajor[] engineerMajors = EngineerMajor.values();
//        for (EngineerMajor engineerMajor : engineerMajors){
//            System.out.println(engineerMajor);
//        }
//        String sample1 = "mechanics";
//        if (Arrays.toString(engineerMajors).contains(sample1)){
//            System.out.println(sample1);
//        }
        System.out.print(StringUtils.removeAccent("Sinh Viên Công Nghệ Thông Tin"));
    }
}
