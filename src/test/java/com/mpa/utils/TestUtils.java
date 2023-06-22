package com.mpa.utils;

import java.util.Random;

public class TestUtils {

    public int generateRandomInteger(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max + 1);
    }

    public int[] generateIntArray(int size, int minValue, int maxValue) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            int random = generateRandomInteger(minValue, maxValue);
            array[i] = random;
        }
        return array;
    }
}
