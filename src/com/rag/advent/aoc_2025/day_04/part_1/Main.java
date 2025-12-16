package com.rag.advent.aoc_2025.day_04.part_1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();


        String fileName;
        if (option == 1) {
            fileName = "input.txt";
        } else {
            fileName = "sample.txt";
        }

        Path p = Path.of(Main.class.getResource(fileName).toURI());
        //Path p = Path.of(Main.class.getResource("input.txt").toURI());
        List<String> lines = Files.readAllLines(p);

        List<Character[]> rows = new ArrayList<>();
        //items are separated by commas
        for (String line : lines) {
            char[] chars = line.toCharArray();
            Character[] row = new Character[chars.length];
            for (int i = 0; i < chars.length; i++) {
                row[i] = chars[i];
            }
            rows.add(row);
        }
        int[] dr = {-1, -1, -1,  0, 0,  1, 1, 1};
        int[] dc = {-1,  0,  1, -1, 1, -1, 0, 1};

        int totalPaperRollCanBeAccessed = 0;

        for (int i = 0; i < rows.size(); i++) {
            Character[] row = rows.get(i);
//            System.out.print("Row " + (i + 1) + ": ");
            int pos = 0;
            for (Character c : row) {
//                System.out.print(c + " ");
//                only need to check @ positions
                if (c == '@') {
                    int adjacentCount = 0;
//                    System.out.print("(Found @) ");
//                    check for all adjacents

                    for(int d=0; d<8;d++){
                        int lookupRow = i + dr[d];
                        int lookupCol = pos + dc[d];
                        Character adjacentChar = getAdjacentCharacter(rows, lookupRow, lookupCol);
                        if(adjacentChar != null && adjacentChar == '@'){
                            adjacentCount++;
                        }
                    }
                    if(adjacentCount < 4 ) {
                        totalPaperRollCanBeAccessed++;
//                        System.out.print("(Accessible) ");
                    }

                }
                pos++;

            }
//            System.out.println();
        }
        System.out.println("Total paper roll that can be accessed: " + totalPaperRollCanBeAccessed);
    }

    public static Character getAdjacentCharacter(List<Character[]> rows, int rowIndex, int colIndex) {
        int numRows = rows.size();
        int numCols = rows.getFirst().length;

        if(rowIndex < 0 || rowIndex >= numRows || colIndex < 0 || colIndex >= numCols) {
            return null; // Out of bounds
        }
        return rows.get(rowIndex)[colIndex];
    }


}
