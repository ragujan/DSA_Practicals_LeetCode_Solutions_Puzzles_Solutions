package com.rag.advent.day_7.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
    record Folder(Set<Folder> folders, List<Integer> files,String foldername) {
    }


    public static void main(String[] args) {
        Folder root = new Folder(new HashSet<Folder>(), new ArrayList<Integer>(),"root");
        root.files.add(10);
        root.files.add(40);


        Folder newFolder = new Folder(new HashSet<>(), new ArrayList<>(),"new folder");
        root.folders.add(newFolder);
        newFolder.files.add(50);
        newFolder.files.add(120);

        System.out.println(root);
        System.out.println(newFolder);

        System.out.println("-----------------");
        printSize(root);
        System.out.println("-----------------");
        printSize(newFolder);
    }

    static int printSize(Folder folder) {
        int fileSize = folder.files.stream().mapToInt(Integer::intValue).sum();
        int folderSize = folder.folders.stream().mapToInt(Main::printSize).sum();
        String folderName = folder.foldername;
        System.out.println("folder name is "+folderName);
        System.out.println("File size is " + fileSize);
        System.out.println("Folder size is " + folderSize);

        return fileSize;

    }
}
