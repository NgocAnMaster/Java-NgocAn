package exception;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so bi chia:");
        int a = sc.nextInt();

        System.out.println("Nhap so chia:");
        int b = sc.nextInt();

//       checkZero(b);
try{
    int divide = divide(a, b);

}catch (IOException e){
    e.printStackTrace();
}

        System.out.println(a / b);


//        int result;
//        try {
//            result = a / b;
//            System.out.println("Ket qua: " + result);
//        } catch (ArithmeticException | NullPointerException e){
//            System.out.println("Loi so hoc hoac null roi");
//        } catch (RuntimeException e){
//            System.out.println("Loi gi day roi");
//        } finally {
//            System.out.println("finally");
//        }
//
//        System.out.println("ben ngoai");

    }
    private static void checkZero(int a)
    {
        if(a==0){
            throw new RuntimeException();
        }
    }

    private static int divide(int a, int b) throws IOException {
        return a / b;
    }
}
