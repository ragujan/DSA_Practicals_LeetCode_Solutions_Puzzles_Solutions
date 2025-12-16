package com.rag.advent.aoc_2025.day_01.part_1;

public class LeftRotationExperiment {

    public static int[] rotateAndCount(int pointAt, int rotationCount) {
        int previousPoint = pointAt;
        pointAt = (pointAt - rotationCount + 100) % 100;
        if(pointAt < 0){
            pointAt += 100;
        }

        int password = 0;

        if(previousPoint- rotationCount == 0){
            password++;
        } else if(rotationCount == 0){
            // No rotation, password remains 0
        } else if(previousPoint - rotationCount < 0 && pointAt == 0){
            int additionalCount = rotationCount / 100;
            if(additionalCount == 0){
                password++;
            } else if(additionalCount > 0 && rotationCount % 100 == 0){
                password += additionalCount;
            } else if(additionalCount > 0){
                password += additionalCount + 1;
            }
        } else if(previousPoint - rotationCount < 0 && pointAt != 0){
            int additionalCount = rotationCount / 100;
            if(additionalCount == 0){
                password++;
            } else if(additionalCount > 0 && rotationCount % 100 == 0){
                password += additionalCount;
            } else if(additionalCount > 0){
                password += additionalCount + 1;
            }
        }

        return new int[]{pointAt, password};
    }
}
