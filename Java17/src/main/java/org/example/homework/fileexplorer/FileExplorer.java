package org.example.homework.fileexplorer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileExplorer {
    // switch this Path into your saving path (IMPORTANT)
    private Path path = Paths.get("D:/A Files/Master Home/AN/Z - More things to do/Coding Files/Java/Java17/src/main/java/org/example/homework/fileexplorer");

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public List<File> list() {
        File file = new File(path.toString());
        List<File> files = List.of(file.listFiles());
        return files;
    }

    public String enter(String name) throws IOException {
        File targetFile = new File(path + "/" + name);
        if (targetFile.isFile()) {
            FileInputStream fileInputStream = new FileInputStream(targetFile);
            byte[] bytes = fileInputStream.readAllBytes();
            String s = new String(bytes);
            return s;
        } else if (targetFile.isDirectory()) {
            setPath(Paths.get(path + "/" + name));
            return null;
        } else {
            throw new RuntimeException("File/Folder not found");
        }
    }

    public void createFile(String name, String content) throws IOException {
        File newFile = new File(path + "/" + name);
        Files.writeString(newFile.toPath(), content);
    }

    public void createFolder(String name) {
        File newFolder = new File(path + "/" + name);
        newFolder.mkdir();
    }

    public void delete(String name) {
        File file = new File(path + "/" + name);
        if (file.isFile() || file.isDirectory()) {
            file.delete();
        } else {
            throw new RuntimeException("File/Folder not found");
        }
    }

    public void rename(String currentName, String newName) {
        File currentFile = new File(path + "/" + currentName);
        if (currentFile.isFile() || currentFile.isDirectory()) {
            File newFile = new File(path + "/" + newName);
            currentFile.renameTo(newFile);
        } else {
            throw new RuntimeException("File/Folder not found");
        }
    }
}
