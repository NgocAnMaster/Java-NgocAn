package org.example.thread;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainParallelStream {
    public static void main(String[] args) {
        List<String> files = List.of("test1.txt", "test2.txt", "test3.txt");
        String target = "D:/A Files/Master Home/AN/Z - More things to do/Coding Files/Java/Java17/src/main/java/org/example/homework/threadandmultithread/";

        List<Integer> sums = new CopyOnWriteArrayList<>();
        File file1 = new File(target + files.get(0));
        File file2 = new File(target + files.get(1));
        File file3 = new File(target + files.get(2));

        List<File> fileList = List.of(file1, file2, file3);
        fileList.parallelStream().forEach(file ->
                addSum(file, sums)
        );

        System.out.println(sums);
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
