package org.example.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String originalFolderPath = "src/main/java/org/example/file/original-folder";
        File file = new File(originalFolderPath);
        List<String> files = Arrays.asList(file.list());
        System.out.println(files);
        String destFolderPath = originalFolderPath + "/dest-folder";
        File destFolder = new File(destFolderPath);
        destFolder.mkdir();

        String file1Path = originalFolderPath + "/file1.txt";
        String file2Path = originalFolderPath + "/file2.txt";
        String file3Path = originalFolderPath + "/file3.txt";
        String file4Path = originalFolderPath + "/file4.txt";
        String file5Path = originalFolderPath + "/file5.txt";

        File file1 = new File(file1Path);
        File destFile1 = new File(destFolderPath + "/file1.txt");
        file1.renameTo(destFile1);

        File file2 = new File(file2Path);
        File destFile2 = new File(destFolderPath + "/file2.txt");
        file2.renameTo(destFile2);

        File file5 = new File(file5Path);
        file5.delete();

        for (File destFile : destFolder.listFiles()) {
            System.out.println(destFile.getName() + " " + new Date(destFile.lastModified()) + " " + destFile.length());

        }
    }
}
