package com.rag.advent.day_7.version_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PartOne2 {

    Map<String, String> subDirectoriesMainDirectories = new HashMap<>();
    Map<String, Integer> fileSizeDirectoryTotal = new HashMap<>();
    public void readFile() {
        File file = new File("src/com/rag/advent/day_7/input2.txt");
        try {
            String cd = "cd";
            String ls = "ls";
            String dir = "dir";
            String $ = "$";

            String switchingDirectory = "";
            String previousDirectory = "";
            String previousCommand = "";
            String currentCommand = "";
            Scanner myScanner = new Scanner(file);

            LinkedList<LinkedList> directories = new LinkedList<>();
            Map<String, String> listsandDirectories = new HashMap();
            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();
                String firstCharacter = Character.toString(line.charAt(0));
                currentCommand = line.substring(2, 4);

                LinkedList<String> directoryLists = new LinkedList<>();
                if (firstCharacter.equals($)) {
                    if (currentCommand.equals(cd)) {
                        previousDirectory = switchingDirectory;
                        switchingDirectory = line.substring(5);

                    }
                    if (currentCommand.equals(ls)) {

                    }
                }

                System.out.println(line);
                if (!firstCharacter.equals($)) {
                    listsandDirectories.put(line, switchingDirectory);
                }
                System.out.println("previous directory was " + previousDirectory + " current directory is " + switchingDirectory);


            }
            System.out.println("++++++++++++");
            System.out.println("++++++++++++");
            System.out.println("++++++++++++");


            for (Map.Entry<String, String> map : listsandDirectories.entrySet()) {
                String directory = map.getValue();
                String line = map.getKey().toString();
                if (line.length() > 4 && line.substring(0, 3).equals(dir)) {
                    String subDirectory = line.substring(4);
                    System.out.println(map.getValue() + " has  " + subDirectory + " as a sub directory");
                    //note down the sub direcotory and its parent directory
                    subDirectoriesMainDirectories.put(subDirectory, map.getValue());

                }

                if (!line.substring(0, 3).equals(dir) && !line.substring(0).equals($)) {

                    int fileSize = Integer.parseInt(line.split(" ")[0]);
                    for (Map.Entry<String, Integer> eachmap : fileSizeDirectoryTotal.entrySet()) {

                         if(eachmap.getKey().equals(directory)){
                             System.out.println("Yes met ");
                             int previousFileSize = eachmap.getValue();
                             System.out.println("Previous value was ");
                             int newValue = previousFileSize+ fileSize;
                             fileSizeDirectoryTotal.put(directory,newValue);
                         }else{
                             break;
                         }


                    }
                    fileSizeDirectoryTotal.put(directory,fileSize);
                    System.out.println("Directory is " + directory + " file size is " + fileSize);
                }
                for (Map.Entry<String, String> subMap : subDirectoriesMainDirectories.entrySet()) {
                    if (map.getValue().toString().equals(subMap.getKey())) {
                        System.out.println(subMap.getValue() + " ((((())))) " + subMap.getKey());
                    }

                }
                System.out.println("++____++++");
            }
            System.out.println("=================");
            System.out.println("=================");
            System.out.println("=================");
            System.out.println("=================");
            for (Map.Entry<String, String> map : subDirectoriesMainDirectories.entrySet()) {
                System.out.println(map.getValue() + " " + map.getKey());
            }

            System.out.println("file size checking");
            this.retriveFileSizeMap();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

    }
    public void retriveFileSizeMap(){
        for (Map.Entry<String,Integer> map: fileSizeDirectoryTotal.entrySet()
             ) {
            System.out.println("file name is "+map.getKey()+" file size is "+map.getValue());
        }
    }
    public static void main(String[] args) {
        PartOne2 pt = new PartOne2();
        pt.readFile();
//        String abc = "ragjn";
//        abc = abc.substring(3);
//        System.out.println(abc);
    }
}
