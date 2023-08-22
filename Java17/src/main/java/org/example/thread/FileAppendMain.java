package org.example.thread;

public class FileAppendMain {
    public static void main(String[] args) {
        AppendThread thread1 = new AppendThread("D:/A Files/Master Home/AN/Z - More things to do/Coding Files/Java/Java17/src/main/java/org/example/thread/test.txt", "this is from thread 1");
        AppendThread thread2 = new AppendThread("D:/A Files/Master Home/AN/Z - More things to do/Coding Files/Java/Java17/src/main/java/org/example/thread/test.txt", "this is from thread 2");

        thread1.start();
        thread2.start();
    }
}
