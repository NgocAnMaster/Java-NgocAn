package org.example.exception;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int num;
        do {
            System.out.println("Nhap so de cong don: ");
            try {
                num = sc.nextInt();
                sum += num;
            }
            catch (Exception e){
                e.printStackTrace();
                System.out.println("An error encountered: Interger required (" + e + ")");
                sc.nextLine();
            }
            finally {
                num = 0;
            }
        } while (true);
    }
}
