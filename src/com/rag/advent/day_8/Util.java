package com.rag.advent.day_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Util {
    static File file = new File("src/com/rag/advent/day_8/input2.txt");
    public static List<String> inputFile(){
//        file = new File("src/com/rag/advent/day_7/tryperfect/sample.txt");
        List<String> list = new LinkedList<>();
        try (Scanner scanner = new Scanner(Util.file)) {
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
