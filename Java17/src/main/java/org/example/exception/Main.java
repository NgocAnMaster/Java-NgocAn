package org.example.exception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap diem: ");
        int score = sc.nextInt();

        if (score <= 100){
            System.out.println("Diem la: " + score);
        } else {
            throw new InvalidScoreException();
        }
    }
}
