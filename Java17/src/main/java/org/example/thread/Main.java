package org.example.thread;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        List<Integer> list = new CopyOnWriteArrayList<>();
        Job job1 = new Job(1, list);
        Job job2 = new Job(2, list);
        job1.start();
        job2.start();
        System.out.println("Da start");

        job1.join();
        job2.join();

        File file = new File("D:/A Files/Master Home/AN/Z - More things to do/Coding Files/Java/Java17/src/main/java/org/example/thread/test.txt");
        for (Integer e : list) {
            appendToFile(file.toPath(), e.toString() + "\n");
        }
        System.out.println(list.size());
    }

    // Java 7
    private static void appendToFile(Path path, String content)
            throws IOException {

        // if file not exists throws java.nio.file.NoSuchFileException
        /* Files.write(path, content.getBytes(StandardCharsets.UTF_8),
						StandardOpenOption.APPEND);*/

        // if file not exists, create and write to it
        // otherwise append to the end of the file
        Files.write(path, content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);

    }
}
