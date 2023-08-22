package org.example.homework.threadandmultithread;

import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String> files = List.of("test1.txt", "test2.txt", "test3.txt");
        String target = "D:/A Files/Master Home/AN/Z - More things to do/Coding Files/Java/Java17/src/main/java/org/example/homework/threadandmultithread/";

//        List<File> filesList = new ArrayList<>();
//
//        for (String file : files) {
//            filesList.add(new File(target + file));
//        }
//
//        List<SumFile> fileSum = new ArrayList<>();
//
//        for (File file : filesList) {
//            fileSum.add(new SumFile(file));
//        }
//
        List<Integer> sums = new CopyOnWriteArrayList<>();
//
//        for (SumFile sumFile : fileSum) {
//            try {
//                sums.add(sumFile.sum());
//            } catch (Exception e) {
//                System.out.println("Error: " + e);
//                e.printStackTrace();
//            }
//        }
//
//        System.out.println(sums);

//        SumFile f1 = new SumFile(target + files.get(0));
//        SumFile f2 = new SumFile(target + files.get(1));
//        SumFile f3 = new SumFile(target + files.get(2));
        File file1 = new File(target + files.get(0));
        File file2 = new File(target + files.get(1));
        File file3 = new File(target + files.get(2));

        SumFile sf1 = new SumFile(file1, sums);
        SumFile sf2 = new SumFile(file2, sums);
        SumFile sf3 = new SumFile(file3, sums);
        sf1.start();
        sf2.start();
        sf3.start();
        System.out.println("Starting sf processes");

        sf1.join();
        sf2.join();
        sf3.join();
        System.out.println(sums);
    }
}
