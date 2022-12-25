package com.rag.advent.day_7.version_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class PartOne {


    String cdCmd = "$ cd";
    String lsCmd = "$ ls";
    String currentDirectory = "";
    public void doStuff() {
        List<String> fileLines = Util.inputFile();
        fileLines.stream().forEach(this::accept);


    }


    public static void main(String[] args) {
        PartOne pt = new PartOne();
        pt.doStuff();
    }

    private void accept(String s) {

        if (s.contains(cdCmd)) {

            currentDirectory = s.split(" ")[2];
        }
        System.out.println(s);
    }
}