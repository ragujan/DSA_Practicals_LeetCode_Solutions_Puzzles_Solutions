package com.rag.advent.day_7.version_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Util {

    public static List<String> inputFile(File file){
        List<String> list = new LinkedList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
