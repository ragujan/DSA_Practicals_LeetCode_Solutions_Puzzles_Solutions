package com.rag.advent.aoc_2025.day_04.part_2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

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
        int grandTotalRemoved = 0;
        while(true){
            Map<Integer, Object> result = paperToBeRemoved(rows);

            int roundCount = (Integer) result.get(1);
            int[][] toBeReplaced = (int[][]) result.get(2);


            if (roundCount == 0) {
                break;
            }
            rows = replaceAccessedPapers(rows, toBeReplaced);
            grandTotalRemoved += roundCount;
        }
        System.out.println("Total paper roll that can be accessed: " + grandTotalRemoved);
    }

    public static Map<Integer,Object> paperToBeRemoved(List<Character[]> rows){

//        first item would be count of papers to be removed
//        second item would be 2D array indicating which papers to be removed

        int[] dr = {-1, -1, -1,  0, 0,  1, 1, 1};
        int[] dc = {-1,  0,  1, -1, 1, -1, 0, 1};

        int totalPaperRollCanBeAccessed = 0;
        int[][] toBeReplaced = new int[rows.size()][rows.getFirst().length];

        for (int i = 0; i < rows.size(); i++) {
            Character[] row = rows.get(i);
            int pos = 0;
            for (Character c : row) {
//                only need to check @ positions
                if (c == '@') {
                    int adjacentCount = 0;
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
                        toBeReplaced[i][pos] = 1;
                    }
                }
                pos++;

            }
        }

        Map<Integer,Object> resultMap = new HashMap<>();
        resultMap.put(1, totalPaperRollCanBeAccessed);
        resultMap.put(2, toBeReplaced);
        return resultMap;

    }

    public static List<Character[]> replaceAccessedPapers(List<Character[]> rows, int[][] toBeReplaced) {

        for (int i = 0; i < toBeReplaced.length; i++) {
            for (int j = 0; j < toBeReplaced[i].length; j++) {
                if (toBeReplaced[i][j] == 1) {
                    rows.get(i)[j] = 'X';
                }
            }
        }
        return rows;
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
