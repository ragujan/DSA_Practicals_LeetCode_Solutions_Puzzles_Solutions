package com.rag.advent.day_7.tryperfect;

import java.util.*;

public class Test {

    String cdCmd = "$ cd";
    String rootCdCmd = "$ cd /";
    String lsCmd = "$ ls";
    String currentDirectory = "";

    public void doStuff() {
        List<String> lines = Util.inputFile();
        Folder folder = null;
        List<Folder> tempFolderList = new LinkedList<>();
        List<String> currentDirList = new LinkedList<>();
        int currentDirIndex = 0;
        int cdi = 0;
        String currentDir = "";

        for (String line : lines) {
            String[] words = line.split(" ");

            if (words.length >= 3 && words[1].equals("cd") && !words[2].equals("..")) {
                System.out.println(line);
                currentDirList.add(words[2]);
            }
        }

        System.out.println("----------");
        currentDirList.forEach(s -> System.out.println(s + " " + currentDirList.indexOf(s)));
        System.out.println("+++++++++");
        for (String line : lines) {
            String[] words = line.split(" ");
            String currentDirectoryCmd = "";
            String cdCmd = words[0] + " " + words[1];


            if (words.length >= 3 && cdCmd.equals(this.cdCmd)) {

                String dir = words[2];
                String rootCdCmd = words[0] + " " + words[1] + " " + words[2];
                if (dir.equals("..")) {
                    currentDirIndex--;
                    currentDir = currentDirList.get(currentDirIndex - 1);
                } else {
                    currentDir = dir;
                    currentDirIndex++;
                    cdi++;
                }

            }
            if (!words[0].equals("$") && !words[0].equals("dir")) {
                System.out.println("\n");
                System.out.println(line);
                Integer fileSize = Integer.parseInt(words[0]);
                int cur = currentDirIndex - 1;
                int currentDirIn = currentDirList.indexOf(currentDir);
                System.out.println("current dir index is " + cur + " curent list index is " + currentDirIn);
                System.out.println("list item according to current index pos " + currentDirList.get(cur) + " current list item " + currentDir);
            }
        }


    }

    public void folderWork() {


    }

    public static void main(String[] args) {
        Test t = new Test();
        t.doStuff();
    }

}
