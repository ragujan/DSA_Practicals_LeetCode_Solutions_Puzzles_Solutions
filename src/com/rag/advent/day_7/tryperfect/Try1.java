package com.rag.advent.day_7.tryperfect;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Try1 {
    String cdCmd = "$ cd";
    String rootCdCmd = "$ cd /";
    String lsCmd = "$ ls";
    String currentDirectory = "";
    List<Map<String, Integer>> folderListAndIndex = new LinkedList<>();
    int dirIndex = 0;
    int dirPosition = 0;

    public void doStuff() {
        List<String> lines = Util.inputFile();
        String currentDir = "";
        for (String line : lines) {

            String[] words = line.split(" ");
            String cdCmd = words[0] + " " + words[1];
            if (words.length >= 3 && cdCmd.equals(this.cdCmd) && !words[2].equals("..")) {
                Map<String, Integer> tempMap = new HashMap<>();
                tempMap.put(words[2], dirIndex);
                folderListAndIndex.add(tempMap);
                dirIndex++;
            }
        }

        for (String line : lines) {
            String[] words = line.split(" ");
            System.out.println(getCurrentDir(dirPosition));
            if (words.length >= 3 && words[2].equals("..")) {
                dirPosition--;
            } else if (words.length >= 3 && !words[2].equals("..")) {
                dirPosition++;
            }

        }
        for (Map<String, Integer> map : folderListAndIndex
        ) {
            for (Map.Entry<String, Integer> entry : map.entrySet()
            ) {
                System.out.println("directory is " + entry.getKey() + " index is " + entry.getValue());
                System.out.println("\n");
            }
        }
    }

    public String getCurrentDir(int index) {
        String currentDir = "";
        for (Map<String, Integer> map : folderListAndIndex) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {

                if (index == entry.getValue()) {
                    currentDir = entry.getKey();
                }
            }
        }
        return currentDir;
    }

    public static void main(String[] args) {
        Try1 try1 = new Try1();
        try1.doStuff();
    }

}
