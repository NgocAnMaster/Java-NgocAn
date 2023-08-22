package org.example.thread;

import lombok.SneakyThrows;

import java.util.List;

public class Job1 extends Thread {
    private int number;
    private List<Integer> list;

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
//            synchronized (list) {
//                list.add(number);
//            }
            list.add(number);
            sleep(1);
        }
    }

//    private static synchronized void add(int number, List<Integer> list) {
//        list.add(number);
//    }
}
