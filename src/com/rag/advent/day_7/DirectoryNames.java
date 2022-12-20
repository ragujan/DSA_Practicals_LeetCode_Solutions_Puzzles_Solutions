package com.rag.advent.day_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DirectoryNames {
    Set<Set> set = new HashSet<>();
    String currentDirectory = "/";
    String previusDirectory = "";

    public void readFile() {
        File file = new File("src/com/rag/advent/day_7/testinput.txt");
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
        DirectoryNames dn = new DirectoryNames();
        dn.readFile();
        System.out.println(dn.set);
    }
}