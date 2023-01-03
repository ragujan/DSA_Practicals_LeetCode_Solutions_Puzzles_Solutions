package com.rag.advent.day_9;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.posH = 1;
        t.posT = 1;

        t.moveH("R 5");
        t.moveH("L 4");
        t.doStuff(Util.inputFileTest());

    }

    public void doStuff(List<String> inst) {
        for (String s : inst) {
        }
    }

    int posH = 1;
    int posT = 1;

    String direction = "";
    Set<Integer> visitedPoints = new HashSet<>();

    public void moveH(String direction) {
        int steps = Integer.parseInt(direction.split(" ")[1]);
        String moveTo = direction.split(" ")[0];
        this.direction = moveTo;
        if (moveTo.equals("R")) {
            posH = posH + steps;
        } else if (moveTo.equals("L")) {
            posH = posH - steps;
        } else if (moveTo.equals("U")) {
            posH = posH + (steps * 6);
        } else if (moveTo.equals("U")) {
            posH = posH - (steps * 6);
        }
        System.out.println("-------------");
        moveT();
    }

    public void tailTrailsSameRow(int currentPos, int movingPosition) {
        if (currentPos - movingPosition > 0) {
            for (int i = currentPos; i >= movingPosition; i--) {
                System.out.println("moving from " + i);
                visitedPoints.add(i);
            }
        }
        if (currentPos - movingPosition < 0) {
            for (int i = currentPos; i <= movingPosition; i++) {
                System.out.println("moving from " + i);
                visitedPoints.add(i);
            }
        }

    }

    public void moveT() {
        //current row and column of Tail
        int rowT = rowFinder(posT);
        int colT = colFinder(posT);

        //current row and column of Head
        int rowH = rowFinder(posH);
        int colH = colFinder(posH);
        System.out.println("current row and column of head is " + rowH + " " + colH);
        System.out.println("current row and column of tail is " + rowT + " " + colT);

        if (rowH == rowT) {
            System.out.println("both are in same row ");
            if (posH - posT > 1 || posT - posH > 1) {
                int currentPos = posT;
                if (this.direction.equals("R")) {
                    posT = posH - 1;
                    tailTrailsSameRow(currentPos, posT);
                } else if (this.direction.equals("L")) {
                    posT = posH + 1;
                    tailTrailsSameRow(currentPos, posT);
                }
                System.out.println("movable");
                this.trackPositions();
            }
        }

        if (colH == colT) {
            System.out.println("both are in same column ");

            if (posH - posT > 6 || posT - posH > 6) {

                if (this.direction.equals("U")) {
                    posT = posH - 6;
                } else if (this.direction.equals("D")) {
                    posT = posH + 6;
                }
                System.out.println("movable");
                this.trackPositions();
            }
        }

        if (colH != colT && rowH != rowT) {
            this.trackPositions();
            System.out.println("wait for diagonal movement");
        }

    }

    public static int colFinder(int position) {
        int remainder = position % 6;
        if (remainder == 0) {
            remainder = 6;
        }
        return remainder;
    }

    public static int rowFinder(int position) {
        int divideValue = position / 6;
        int row = 0;
        if (divideValue >= 0 && divideValue <= 1) {
            row = 1;
        } else if (divideValue > 1 && divideValue <= 2) {
            row = 2;
        } else if (divideValue > 2 && divideValue <= 3) {
            row = 3;
        } else if (divideValue > 3 && divideValue <= 4) {
            row = 4;
        } else if (divideValue > 4 && divideValue <= 5) {
            row = 5;
        }
        return row;
    }

    public void trackPositions() {

        System.out.println("Pos H " + this.posH + " Pos T " + this.posT);

    }
}
