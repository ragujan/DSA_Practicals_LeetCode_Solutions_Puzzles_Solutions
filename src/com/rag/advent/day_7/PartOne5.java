package com.rag.advent.day_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PartOne5 {
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

    Map<String, Integer> eachDirectoryFileSizes;

    Set<Set<String>> setDirectory;
    List<List<String>> setToList;

    public PartOne5() {
        line = "";

        commandChar = "$";
        commandList = "ls";
        commandChangeDir = "cd";
        previousDirectory = "";
        currentDirectory = "";

        mapDirectories = new HashMap<>();
        directories = new LinkedList<>();
        subDirectoriesMainDirectories = new HashMap<>();
        eachDirectoryFileSizes = new HashMap<>();

        setDirectory = new LinkedHashSet<>();
        setToList = new LinkedList<>();

    }

    public void fileReader(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String firstCharacter = line.substring(0, 1);
                //if the line first character is $ and line.substring(2,4) equals to "cd" then goes into this
                if (firstCharacter.equals(commandChar) && line.substring(2, 4).equals(commandChangeDir)) {
                    // if line is is not about cd .. then
                    // $ cd .. is line.subString(5)
                    if (!line.substring(5).equals("..")) {
                        previousDirectory = currentDirectory;
                        currentDirectory = line.substring(5);
                    }
                }


                //add files into a map, key is file name and size , value is directory
                if (!line.substring(0, 1).equals(commandChar)) {
                    if (line.length() > 3 && !line.substring(0, 3).equals("dir")) {
                        //add files such as 12233 j.txt
                        mapDirectories.put(line, currentDirectory);
                    } else {
                        // add lines such as dir a, only add the directory name
                        //dir a -> a gets all
                        mapDirectories.put(line.substring(4), currentDirectory);
                        //to add the sub directories to the main directories
                        //if the current direcotory is / and the line is about dir a
                        //then the it goes like this
                        // subDirecotoriesMainDirecotries.put("a","/");
                        // subDirecotoriesMainDirecotries.put("d","/");
                        // subDirecotoriesMainDirecotries.put("e","a");

                        subDirectoriesMainDirectories.put(line.substring(4), currentDirectory);
                    }
                }
                //file sizes of each individual directory
                //a-> 333;
                //e-> 200;
                //if the line is not an command then it has to be either a dir or a file name
                if (!line.substring(0, 1).equals(commandChar) && line.length() > 3 && !line.substring(0, 3).equals("dir")) {

                    //separate only the numbers of that line
                    //since we have ingored the command lines and dir lines
                    // 34556 j.txt
                    // separate only the number
                    int fileSize = Integer.parseInt(line.split(" ")[0]);
                    boolean keyFound = false;

                    //so plan is to add the dir name and its size
                    //key would be the dir and the value would be the file size
                    //first have to if eachDirectoryFileSizes has the directory in it if not
                    //add it to separately
                    //if it there
                    //get the current value add it with previous value then update the key and value pairs
                    for (Map.Entry<String, Integer> totalMap : eachDirectoryFileSizes.entrySet()) {
                        if (totalMap.getKey().equals(currentDirectory)) {
                            keyFound = true;
                            fileSize = fileSize + totalMap.getValue();
                            eachDirectoryFileSizes.put(currentDirectory, fileSize);

                        }
                    }
                    if (!keyFound) {
                        eachDirectoryFileSizes.put(currentDirectory, fileSize);
                    }

                }

            }


            for (Map.Entry<String, String> map : mapDirectories.entrySet()) {
                String mapKey = map.getKey();
                String mapValue = map.getValue();

                System.out.println("Map key is " + mapKey + " map value is " + mapValue);
                Set<String> myset = new LinkedHashSet<>();
                myset.add(mapValue);
                List<String> myList = new LinkedList<>();
                myList.add(mapValue);
                for (Map.Entry<String, String> subMap : subDirectoriesMainDirectories.entrySet()) {
                    String subMapKey = subMap.getKey();
                    String subMapValue = subMap.getValue();
                    System.out.println("sub map key is " + subMapKey + " sub map value is " + subMapValue);
                    if (mapValue.equals(subMapValue)) {
                        myset.add(subMapKey);
                        myList.add(subMapKey);
                    }
                    if (mapKey.equals(subMapValue)) {

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
        List<List<String>> list = new LinkedList<>();
        List<List<String>> reverseListMain = new LinkedList<>();


        for (List<String> changeList : setToList) {
            reverseListMain.add(reverseLists(changeList));
        }

        setToList = reverseLists(reverseListMain);
        System.out.println(setToList);
    }

    public List reverseLists(List list) {
        List reverseList = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reverseList.add(list.get(i));
        }
        return reverseList;
    }

    public void test() {
        for (List<String> list : setToList) {
            System.out.println("directory sets are being iterated ");
            System.out.println("main dir is " + list.get(list.size() - 1));
            int size = 0;
            String finalDir = "";
            for (String dir : list) {

                for (Map.Entry<String, Integer> entry : eachDirectoryFileSizes.entrySet()
                ) {
                    if (entry.getKey().equals(dir)) {
                        size += entry.getValue();
                        System.out.println("file size of " + dir + " is " + size);
                        finalDir = entry.getKey();
                    }
                }


            }
            System.out.println("Final dir is " + finalDir);
            System.out.println("fina dir size is " + size);
            System.out.println("\n");
        }
    }

    public void test2() {
        for (List<String> list : setToList
        ) {
            System.out.println(list);
            for (String separateDir : list
            ) {
                int filesize = 0;
                for (List<String> list2:setToList
                     ) {
//                    System.out.println(list2.get(list2.size()-1));
                }
                for (Map.Entry<String,Integer> entry: eachDirectoryFileSizes.entrySet()
                     ) {
                   if(entry.getKey().equals(separateDir)){
                       filesize = entry.getValue();
                       System.out.println("file "+separateDir+" is "+filesize);
                   }
                }
            }
        }
    }
    public void checkMapContains() {

    }
    public void calculateWholeDirectory() {

        Map<String, Integer> calculatedDirmap = new HashMap<>();
        for (List<String> list : setToList) {
            String mainDir = "";
            int totalSizeforEachMainDir = 0;
            System.out.println(list);

            for (String dir : list) {
                for (Map.Entry<String, Integer> entry : eachDirectoryFileSizes.entrySet()) {
                    String fileName = entry.getKey();
                    Integer fileSize = entry.getValue();

                    if (fileName.equals(dir)) {
                        totalSizeforEachMainDir += fileSize;
                        mainDir = fileName;
                    }
                }
            }

            calculatedDirmap.put(mainDir, totalSizeforEachMainDir);
        }
        calculatedDirmap.forEach((key, value) -> System.out.println("dir " + key + " size is " + value));
    }

    public static void main(String[] args) {

        PartOne5 pt = new PartOne5();
        pt.fileReader(pt.file);
        pt.eachDirectoryFileSizes.forEach((key, value) -> System.out.println("file is " + key + " size is " + value));

        pt.transferToLinkedList();
//        pt.calculateWholeDirectory();
        System.out.println("-----------------------------------ragjn");
//        pt.test();
        pt.test2();


    }
}

abstract class Util {

    abstract public void loopAMapAndDoStuff(Map map);

    public void doStuff() {

    }

}