package com.rag.advent.day_7.tryperfect;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Try2 {
    List<Folder> folderHolder = new LinkedList<>();
    String cdRootCmd = "$ cd /";
    String cdCmd = "$ cd";
    String lsCmd = "$ ls";
    boolean lsMode = false;

    String currentDir = "";
    public void doStuff() {
        List<String> lines = Util.inputFile();
        Folder folder = null;

        for (String line : lines) {
            String[] words = line.split(" ");

            // if command is $ ls activate lsMode
            // if command is $ cd deactivate lsMode
            if (words.length >= 3 && (words[0] + " " + words[1]).equals(this.cdCmd)) {

                lsMode = false;
                currentDir = words[2];
                folder = new Folder(currentDir," ",new HashSet<>(),new LinkedList<>());

            } else if (words.length == 2 && (words[0] + " " + words[1]).equals(lsCmd)) {
                lsMode = true;
            }

            if(lsMode && !words[0].equals("$")){
               if(words[0].equals("dir")) {
                   String dir = words[1];
                   folder.folders.add(new Folder(dir,currentDir,new HashSet<>(),new LinkedList<>()));
               }else{
                   Integer fileSizes = Integer.parseInt(words[0]);
                   folder.files.add(fileSizes);
               }
            }else if(words.length>=3){
                String cdDir = words[2];
                if(cdDir.equals("..")){
                }
            }

            System.out.println("current dir is "+currentDir);
//            System.out.println("Parent dir is "+folder.getParentDir());

        }
    }

    public static void main(String[] args) {
        Try2 t = new Try2();
        t.doStuff();

    }
}
