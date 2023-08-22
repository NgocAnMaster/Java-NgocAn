package org.example.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TestCF {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> thread1 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(1);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        CompletableFuture<Void> thread2 = CompletableFuture.runAsync(() -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println(1);
//                try {
//                    Thread.sleep(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            System.out.println("xin chao");
        });

        thread1.get();
        thread2.get();
    }
}
