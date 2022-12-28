package com.rag.advent.day_7.tryperfect;

import java.util.*;

public class Try3 {
    String currentDir = "";
    String parentDir = "";
    String cdCmd = "$ cd";
    String lsCmd = "$ ls";
    List<String> lines = Util.inputFile();
    List<String> dirList = new LinkedList<>();
    Map<Integer, String> dirIdList = new HashMap<>();
    int dirIndex = 0;

    public void doStuff() {

        String currentDir = "";
        int index = 0;
        boolean isLsModeActivated = false;
        Folder folder = null;
        Folder2 f = new Folder2("/",null, new HashSet<>(),new LinkedList<>());

        for (String line : lines) {
            addDirectories(line);
        }
        addIdDirectory(lines);
//        dirIdList.forEach((integer, s) -> System.out.println("Id is "+integer+" dir is "+s));

        //toggle the current directory in
        for (String line : lines) {
            String[] words = line.split(" ");
            if (words.length >= 3 && (words[0] + " " + words[1]).equals(cdCmd)) {
                isLsModeActivated = false;
                if (words[2].equals("..")) {
                    dirIndex--;
                } else {
                    dirIndex++;
                    index++;
                }
                int parentDirIndex = dirIndex - 2;
                int currentDirIndex = dirIndex - 1;
                if (parentDirIndex < 0) {
                    parentDir = "";
                } else {
                    parentDir = dirList.get(parentDirIndex);
                }

                currentDir = dirList.get(dirIndex - 1);
//                System.out.println("parent directory index is " + parentDirIndex + " crrent directory index is " + currentDirIndex);
//                System.out.println("parent directory is " + parentDir + " crrent directory is " + currentDir);
                folder = new Folder(currentDir,parentDir,new HashSet<>(),new LinkedList<>());

            }
            // if line is $ ls
            if ((words[0] + " " + words[1]).equals(lsCmd)) {
                isLsModeActivated = true;
            }
            if (!words[1].equals("ls") && !words[1].equals("cd")) {
                System.out.println(line);
                if(words[0].equals("dir")){

                   folder.folders.add(new Folder(words[1],currentDir, new HashSet<>(),new LinkedList<>()));
                }else{
                    Integer fileSize = Integer.parseInt(words[0]);
                    folder.files.add(fileSize);
                }
            }
        }


    }

    public void addDirectories(String inputLine) {
        for (String line : lines) {
            if (line.equals(inputLine)) {

                String[] words = inputLine.split(" ");
                if ((words[0] + " " + words[1]).equals(cdCmd)) {
                    if (!words[2].equals("..")) {
                        dirList.add(words[2]);
                    }
                }
                break;
            }
        }

    }
    public void addIdDirectory(List<String> lines) {
        int id = 0;
        for (String line : lines) {

                String[] words = line.split(" ");
                if ((words[0] + " " + words[1]).equals(cdCmd)) {
                    if (!words[2].equals("..")) {
                        dirIdList.put(id, words[2]);
                        id++;
                    }
                }
        }

    }
    public static void main(String[] args) {
        Try3 t = new Try3();
        t.doStuff();
    }
}
