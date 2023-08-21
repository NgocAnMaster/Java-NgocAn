package org.example.homework.fileexplorer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
//import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileExplorer path = new FileExplorer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to File Explorer system!");
        do {
            System.out.println("What do you want to do?");
            System.out.println("1. List the files");
            System.out.println("2. Find a file or folder");
            System.out.println("3. Create a new file");
            System.out.println("4. Create a new folder");
            System.out.println("5. Delete a file or folder");
            System.out.println("6. Rename a file or folder");
            System.out.println("7. Rename path");
            int choice = 0;
            do {
                try {
                    System.out.print("Pick a choice: ");
                    choice = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Error encountered: " + e);
                    e.printStackTrace();
                    if (e.toString().equals("java.util.InputMismatchException")) {
                        System.out.println("Invalid input. You must enter a value choice.");
                    }
                    sc.nextLine();
                }
            } while (choice < 1 || choice > 7);
            System.out.println("Your choice is: " + choice);
            switch (choice) {
                case 1: {
                    System.out.println("Files in directory " + path.getPath() + ":");
                    System.out.println(path.list());
                    break;
                }
                case 2: {
                    sc.nextLine();
                    try {
                        System.out.println("Which file/folder do you want to find?");
                        String finder = sc.nextLine();
                        System.out.println(path.enter(finder));
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                        if (e.getLocalizedMessage() != null) {
                            System.out.println("Error encountered while finding the file: " + e.getLocalizedMessage());
                        } else {
                            System.out.println("Error encountered while finding the file: " + e);
                        }

                    }
                    break;
                }
                case 3: {
                    sc.nextLine();
                    System.out.print("Enter the name of your new file: ");
                    String newFileName = sc.nextLine();
                    File file = new File(path + "/" + newFileName);
                    System.out.println("Enter the content of your new file:");
                    String newFileContent = sc.nextLine();
//                    if (file.isFile() && file.exists()) {
//                        System.out.println("Overwrite " + newFileName + "? (press Y to overwrite now, or any key to cancel):");
//                        String confirm = sc.next();
//                        System.out.println(confirm);
//                        if (confirm.equals("Y") || confirm.equals("y")) {
//                            path.createFile(newFileName, newFileContent);
//                            System.out.println("File created: " + newFileName);
//                        }
//                    } else {
//                        path.createFile(newFileName, newFileContent);
//                        System.out.println("File created: " + newFileName);
//                    }
                    path.createFile(newFileName, newFileContent);
                    System.out.println("File created: " + newFileName);
                    break;
                }
                case 4: {
                    sc.nextLine();
                    System.out.println("Enter the name of your new directory: ");
                    String dirName = sc.nextLine();
                    path.createFolder(dirName);
                    System.out.println("Directory created: " + dirName);
                    break;
                }
                case 5: {
                    sc.nextLine();
                    try {
                        System.out.print("Specify a file/folder you want to delete: ");
                        String fileToDelete = sc.nextLine();
                        path.delete(fileToDelete);
                        System.out.println("File/Folder deleted: " + fileToDelete);
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                        if (e.getLocalizedMessage() != null) {
                            System.out.println("Error encountered while finding the file: " + e.getLocalizedMessage());
                        } else {
                            System.out.println("Error encountered while finding the file: " + e);
                        }
                    }
                    break;
                }
                case 6: {
                    sc.nextLine();
                    try {
                        System.out.print("Specify a file/folder you want to rename: ");
                        String fileToRename = sc.nextLine();
                        System.out.print("Enter a new name for " + fileToRename + ": ");
                        String newName = sc.nextLine();
                        path.rename(fileToRename, newName);
                        System.out.println("File/Folder renamed: " + fileToRename + " -> " + newName);
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                        if (e.getLocalizedMessage() != null) {
                            System.out.println("Error encountered while finding the file: " + e.getLocalizedMessage());
                        } else {
                            System.out.println("Error encountered while finding the file: " + e);
                        }
                    }
                    break;
                }
                case 7: {
                    sc.nextLine();
                    System.out.println("The current path is " + path.getPath());
                    System.out.print("Enter the new path: ");
                    String newPath = sc.nextLine();
                    path.setPath(Paths.get(newPath));
                    break;
                }
                default: {
                    System.out.println("Invalid choice, please try again.");
                    break;
                }
            }
        } while (true);
    }
}
