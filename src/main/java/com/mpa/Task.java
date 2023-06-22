package com.mpa;

public class Task {

    public int getSumOfTwoMinElements(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("The array must contain at least two elements!");
        }

        int arraySize = array.length;
        int min = Integer.MAX_VALUE;
        int previousMin = min;

        int leftIndex = 0;
        int rightIndex = arraySize - 1;
        while (leftIndex <= rightIndex) {
            int currentLeftSideElement = array[leftIndex];
            if (currentLeftSideElement <= min) {
                previousMin = min;
                min = currentLeftSideElement;
            } else if (currentLeftSideElement < previousMin) {
                previousMin = currentLeftSideElement;
            }

            if (rightIndex != leftIndex) {
                int currentRightSideElement = array[rightIndex];
                if (currentRightSideElement <= min) {
                    previousMin = min;
                    min = currentRightSideElement;
                } else if (currentRightSideElement < previousMin) {
                    previousMin = currentRightSideElement;
                }
            }
            leftIndex++;
            rightIndex--;
        }
        return min + previousMin;
    }
}
