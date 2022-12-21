package com.rag.advent.day_7.version_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PartOne {
    public void readFile() {
        File file = new File("src/com/rag/advent/day_7/input2.txt");
        try {
            String currentDirectory = "";
            String previousDirectory = "";
            String command = "";
            String previousCommand = "";
            Scanner myScanner = new Scanner(file);
            LinkedList<Map<String, String>> directories = new LinkedList<>();
            Map<String, String> directoryMaps = new HashMap<>();
            while (myScanner.hasNextLine()) {
                String line = myScanner.nextLine();

                List<String> lists = new ArrayList<>();

                String firstCharacter = Character.toString(line.charAt(0)) ;
                String commandFirstCharacter = Character.toString(line.charAt(2));
                if (firstCharacter.equals("$")) {

                    previousCommand = command;

                    if (commandFirstCharacter.equals("c")) {
                        command = "cd";
                        previousDirectory = currentDirectory;
                        currentDirectory = line.substring(5);
                    }
                    if (commandFirstCharacter.equals("l")) {
                        command = "ls";
                    }
                }
                if (command.equals("ls")) {
//                    if (!firstCharacter.equals("l") && !firstCharacter.equals("d") && !firstCharacter.equals("$")) {
                        System.out.println("switched to " +currentDirectory +" from " + previousDirectory);
                        directoryMaps.put(line, currentDirectory);
//                    }
                }
                System.out.println(line);
                System.out.println("previous command was " + previousCommand + " current command is " + command);
                System.out.println("previous directory was " + previousDirectory + " current directory is " + currentDirectory);
                System.out.println("---------------");
            }
            System.out.println("=+++++++-");
            for (Map.Entry<String, String> map : directoryMaps.entrySet()
            ) {
                System.out.println("file is " +map.getKey() + " directory is " + map.getValue());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

    }

    public static void main(String[] args) {
        PartOne pt = new PartOne();
        pt.readFile();
//        String abc = "ragjn";
//        abc = abc.substring(3);
//        System.out.println(abc);
    }
}
