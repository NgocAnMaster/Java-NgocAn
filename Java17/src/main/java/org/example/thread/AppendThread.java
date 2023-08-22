package org.example.thread;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AppendThread extends Thread {
    private String filename;
    private String content;

    public AppendThread(String filename, String content) {
        this.filename = filename;
        this.content = content;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (filename) {
            Path path = Paths.get(filename);
            for (int i = 0; i < 10; i++) {
                List<String> lines = Files.readAllLines(path);
                lines.add(content);
                Files.write(path, lines);
            }
        }
    }
}
