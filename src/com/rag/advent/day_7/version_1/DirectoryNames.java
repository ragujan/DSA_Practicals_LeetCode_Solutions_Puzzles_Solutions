package com.rag.advent.day_7.version_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Logger;

public class DirectoryNames {
    Set<Set> set = new HashSet<>();
    String currentDirectory = "/";
    String previusDirectory = "";

    public void readFile() {
        System.out.println("HAH");
        File file = new File("src/com/rag/advent/day_7/input2.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.length() > 3 && line.substring(0, 4).equals("$ cd")) {
                    String dirctory = line.substring(5);
                    previusDirectory = currentDirectory;
                    currentDirectory = dirctory;
                    System.out.println("Prv dir " + previusDirectory + " cur dir " + currentDirectory);
                    if (!currentDirectory.equals("..")) {
                        Set<String> myList = new HashSet<>();
                        myList.add(currentDirectory);
                        set.add(myList);
                    }

                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(DirectoryNames.class.getName());
        DirectoryNames dn = new DirectoryNames();
        dn.readFile();
        System.out.println(dn.set);
        String abc = "abcdefgh";
//        System.out.println(abc.split("abc")[0]);
    }
}
