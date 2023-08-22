package org.example.homework.threadandmultithread;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class SumFile extends Thread {
//    private String path;
//
//    public int sum() {
//        File f = new File(path);
//        Scanner sc = new Scanner(f.toString().replaceAll("\n", "\\n"));
//        Scanner line = new Scanner(sc.nextLine());
//        int sum = 0;
//        try {
//            for (int i = 0; line.hasNextInt(); i++) {
//                if (i > 0) {
//                    sum = sum + line.nextInt();
//                } else {
//                    line.nextInt();
//                }
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("Unexpected error: " + e.getCause().toString());
//        }
//        return sum;
//    }

    private File file;
    private List<Integer> sums;

    @SneakyThrows
    @Override
    public void run() {
        addSum(file, sums);
        sleep(1);
    }

    public static synchronized void addSum(File file, List<Integer> s) {
        s.add(sum(file));
    }

    @SneakyThrows
    public static int sum(File file) {
//        System.out.println(readFile(file));
        Scanner sc = new Scanner(readFile(file));

        if (!sc.hasNextLine()) {
            return 0;
        }

        Scanner line = new Scanner(sc.nextLine());

        int sum = 0;
        int lineInt = 0;
        try {
            for (int i = 0; line.hasNextInt(); i++) {
                lineInt = line.nextInt();
//                if (i > 0) {
//                    sum = sum + lineInt;
//                } else {
////                    line.nextInt();
//                }
                sum = sum + lineInt;
//                System.out.println(lineInt);
//                sc.nextLine();
                if (sc.hasNextLine()) {
                    line = new Scanner(sc.nextLine());
                }
//                System.out.println(line.hasNextInt());
            }
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error: " + e);
        }
        return sum;
    }

    public static String readFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = fileInputStream.readAllBytes();
        String s = new String(bytes);
        return s;
    }
}
