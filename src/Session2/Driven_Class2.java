package Session2;

import java.util.ArrayList;
import java.util.Scanner;
public class Driven_Class2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập số lần thực hiện chức năng:");
//        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Employee> employees = new ArrayList<>();
        while(true) {
            System.out.println("Bạn muốn chọn chức năng nào?");
            System.out.println("1. Thêm mới nhân viên");
            System.out.println("2. Tìm kiếm nhân viên");
            System.out.println("Done => kết thúc chương trình");
            String OperName = sc.nextLine();
            if(OperName.equals("Done")) break;
            int oper = Integer.parseInt(OperName);
            if (oper == 1) {
                System.out.println("Vui lòng nhập chức vụ của nhân viên - 1. Công nhân, 2. Kỹ sư, 3. Nhân viên văn phòng");
                int oper2 = Integer.parseInt(sc.nextLine());
                System.out.println("Vui lòng nhập tên:");
                String name = sc.nextLine();
                System.out.println("Vui lòng nhập tuổi:");
                int age = Integer.parseInt(sc.nextLine());
                System.out.println("Vui lòng nhập giới tính:");
                String gender = sc.nextLine();
                System.out.println("Vui lòng nhập địa chỉ:");
                String address = sc.nextLine();
                if (oper2 == 1) {
                    System.out.println("Vui lòng nhập level: ");
                    int level = Integer.parseInt(sc.nextLine());
                    employees.add(new Labol(name, age, gender, address, level));
                } else if (oper2 == 2) {
                    System.out.println("Vui lòng nhập chuyên ngành: ");
                    String major = sc.nextLine();
                    System.out.println("Vui lòng nhập level: ");
                    String level = sc.nextLine();
                    employees.add(new Engineer(name, age, gender, address, major, level));
                } else if (oper2 == 3) {
                    int yOe = Integer.parseInt(sc.nextLine());
                    employees.add(new Officer(name, age, gender, address, yOe));
                }
                System.out.println("Kết quả đã được lưu thành công!");
            } else if (oper == 2) {
                System.out.println("Nhập từ khoá để tìm kiếm:");
                String findingKey = sc.nextLine();
                System.out.println("-------------------------------");
                System.out.println("Các kết quả tìm được:");
                for (int j = 0; j < employees.size(); j++) {
                    if (employees.get(j).getName().contains(findingKey)) {
                        System.out.println(employees.get(j));
                    }
                }
                System.out.println("------------------------------");
            }
        }
    }
}

