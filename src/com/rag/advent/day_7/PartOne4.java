package com.rag.advent.day_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PartOne4 {
    File file = new File("src/com/rag/advent/day_7/input2.txt");
    String line;
    String commandChar;
    String commandList;
    String commandChangeDir;

    String previousDirectory;
    String currentDirectory;
    List<List<String>> directories;
    Map<String, String> mapDirectories;

    Map<String, String> subDirectoriesMainDirectories;

    Map<String, Integer> directoryTotal;

    Set<Set<String>> setDirectory;
    List<List<String>> setToList;

    public PartOne4() {
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

        setDirectory = new LinkedHashSet<>();
        setToList = new LinkedList<>();

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
//                        System.out.println(fileSize);
                        boolean keyFound = false;
                        for (Map.Entry<String, Integer> totalMap : directoryTotal.entrySet()) {
                            if (totalMap.getKey().equals(currentDirectory)) {
                                keyFound = true;
                                fileSize = fileSize + totalMap.getValue();
                                directoryTotal.put(currentDirectory, fileSize);

                            }
                        }
                        if (!keyFound) {
                            directoryTotal.put(currentDirectory, fileSize);
                        }
                    } else {
                    }
                }

//                System.out.println("previous directory was " + previousDirectory + " current directory is " + currentDirectory);
            }


            for (Map.Entry<String, String> map : mapDirectories.entrySet()) {
                String mapKey = map.getKey();
                String mapValue = map.getValue();
                System.out.println("-------------------------------------------------");
                System.out.println("map key is " + mapKey + " map value  is " + mapValue);
                Set<String> myset = new LinkedHashSet<>();
                myset.add(mapValue);

                List<String> myList = new LinkedList<>();
                myList.add(mapValue);
                for (Map.Entry<String, String> subMap : subDirectoriesMainDirectories.entrySet()) {
                    String subMapKey = subMap.getKey();
                    String subMapValue = subMap.getValue();

                    if (mapValue.equals(subMapValue)) {
                        System.out.println("+++++ bro +++++");
                        myset.add(subMapKey);
                        myList.add(subMapKey);
                    }
                    System.out.println("Submap key is " + subMapKey + " submap value is " + subMapValue);
                    if (mapKey.equals(subMapValue)) {
                        System.out.println("in this case the sub directory  " + subMapKey + " value should be added to the directory " + mapKey);

                    }

                }
                setDirectory.add(myset);
                directories.add(myList);
            }
        } catch (FileNotFoundException ioex) {
            ioex.printStackTrace();
        }
    }

    public void transferToLinkedList() {
        Iterator it = setDirectory.iterator();

        while (it.hasNext()) {
            Set<String> mySet = (Set<String>) it.next();
            List<String> myList = new LinkedList<>();
            Iterator insideIt = mySet.iterator();
            while (insideIt.hasNext()) {
                String dir = (String) insideIt.next();
                myList.add(dir);
            }
            setToList.add(myList);

        }
    }

    public static void main(String[] args) {

        PartOne4 pt = new PartOne4();
        pt.fileReader(pt.file);
//        pt.directories.stream().forEach(directory-> System.out.println(directory));
//        pt.mapDirectories.forEach((key,value)-> System.out.println("file name is "+ key+" directory is "+value));
        System.out.println("------");
//        pt.subDirectoriesMainDirectories.forEach((key,value)-> System.out.println("file name is "+ key+" directory is "+value));
        pt.directoryTotal.forEach((key, value) -> System.out.println("file is " + key + " size is " + value));

        System.out.println("--------------");
        System.out.println(pt.setDirectory);
        System.out.println("))))))))))))))))))))))))))))))))))))))))))))))");
//        System.out.println(pt.directories);
//        for (list<string> list:pt.directories
//             ) {
//            system.out.println(list);
//        }
        pt.transferToLinkedList();
        System.out.println("000000000000000000000000000000000000000");
        Set<Integer> totalSize = new HashSet<>();
        Map<String,Integer> totalSizeWholeDirectory = new HashMap<>();
        int wholeDirTotal = 0;
        for (List<String> list : pt.setToList) {
            int total = 0;
            System.out.println("************");
            for (String dir : list) {
                for (Map.Entry<String, Integer> entry : pt.directoryTotal.entrySet()) {
                    String entryKey = entry.getKey();
                    int entryValue = entry.getValue();
                    if (entryKey.equals(dir)) {
                        System.out.println("value of dir " + dir + " is " + entryValue);
                        total += entryValue;
                    }
                }
            }

            System.out.println("dir size is " + total);
            totalSize.add(total);
        }


        System.out.println("######################");
        System.out.println(totalSize);

    }
}
