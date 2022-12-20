package com.rag.advent.day_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PartOne3 {

    String line;
    String commandChar;
    String commandList;
    String commandChangeDir;

    String previousDirectory;
    String currentDirectory;
    List<String> directories;
    Map<String, String> mapDirectories;

    Map<String, String> subDirectoriesMainDirectories;

    Map<String, Integer> directoryTotal;

    public PartOne3() {
        line = "";

        commandChar = "$";
        commandList = "ls";
        commandChangeDir = "cd";
        previousDirectory = "";
        currentDirectory = "";

        mapDirectories = new HashMap<>();
        directories = new LinkedList<>();
        subDirectoriesMainDirectories = new HashMap<>();
        directoryTotal = new HashMap<>();

    }

    public void fileReader(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
//                System.out.println(line);
                String firstCharacter = line.substring(0, 1);
//                System.out.println(firstCharacter);
                if (firstCharacter.equals(commandChar) && line.substring(2, 4).equals(commandChangeDir)) {
                    if (!line.substring(5).equals("..")) {
                        previousDirectory = currentDirectory;
                        currentDirectory = line.substring(5);
                    }
                }


                //add files into a map, key is file name and size , value is directory
                if (!line.substring(0, 1).equals(commandChar)) {
                    if (line.length() > 3 && !line.substring(0, 3).equals("dir")) {
                        mapDirectories.put(line, currentDirectory);
                    } else {
                        mapDirectories.put(line.substring(4), currentDirectory);
//                        System.out.println(line.substring(4)+" brobro");
                        subDirectoriesMainDirectories.put(line.substring(4), currentDirectory);
                    }
                }
                if (!line.substring(0, 1).equals(commandChar)) {

                    if (line.length() > 3 && !line.substring(0, 3).equals("dir")) {
                        int fileSize = Integer.parseInt(line.split(" ")[0]);
                        System.out.println(fileSize);
                        boolean keyFound = false;
                        for (Map.Entry<String, Integer> totalMap : directoryTotal.entrySet()
                        ) {
                            if (totalMap.getKey().equals(currentDirectory)) {
                                keyFound = true;
                                fileSize  = fileSize + totalMap.getValue();
                                directoryTotal.put(currentDirectory,fileSize);

                            }
                        }
                        if(!keyFound){
                            directoryTotal.put(currentDirectory,fileSize);
                        }
                    } else {
                    }
                }

//                System.out.println("previous directory was " + previousDirectory + " current directory is " + currentDirectory);
            }


            for (Map.Entry<String, String> map : mapDirectories.entrySet()
            ) {
                String mapKey = map.getKey();
                String mapValue = map.getValue();
                for (Map.Entry<String, String> subMap : subDirectoriesMainDirectories.entrySet()
                ) {
                    String subMapKey = subMap.getKey();
                    String subMapValue = subMap.getValue();

//                    System.out.println("map key  is "+mapKey+" map value  is " +mapValue);
//                    System.out.println("Submap key is "+subMapKey+" submap value is "+subMapValue);
                    if (mapKey.equals(subMapValue)) {
                        System.out.println("in this case the sub directory  "+subMapKey+" value should be added to the directory "+mapKey);

                    }

                }
            }
        } catch (FileNotFoundException ioex) {
            ioex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File("src/com/rag/advent/day_7/testinput.txt");
        PartOne3 pt = new PartOne3();
        pt.fileReader(file);
//        pt.directories.stream().forEach(directory-> System.out.println(directory));
//        pt.mapDirectories.forEach((key,value)-> System.out.println("file name is "+ key+" directory is "+value));
        System.out.println("------");
//        pt.subDirectoriesMainDirectories.forEach((key,value)-> System.out.println("file name is "+ key+" directory is "+value));
        pt.directoryTotal.forEach((key, value) -> System.out.println("file is " + key + " size is " + value));
    }
}
