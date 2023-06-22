package com.mpa;

import com.mpa.utils.TestUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TaskTest {

    private static Task task;
    private static TestUtils testUtils;

    @BeforeAll
    static void beforeAll() {
        task = new Task();
        testUtils = new TestUtils();
    }

    @Test
    void testGetSumOfTwoMinElementsWhenArrayIsNull() {
        assertThrows(IllegalArgumentException.class, () -> task.getSumOfTwoMinElements(null));
    }

    @Test
    void testGetSumOfTwoMinElementsWhenArrayIsEmpty() {
        int[] array = new int[]{};
        assertThrows(IllegalArgumentException.class, () -> task.getSumOfTwoMinElements(array));
    }

    @Test
    void testGetSumOfTwoMinElementsWhenArrayHasOneElement() {
        int value = 100;
        int[] array = new int[]{value};
        assertThrows(IllegalArgumentException.class, () -> task.getSumOfTwoMinElements(array));
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    void testGetSumOfTwoMinElementsWithRandomArrays(int[] array, int expected) {
        int actual = task.getSumOfTwoMinElements(array);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> getArguments() {
        int targetMin = -99;
        int targetPreviousMin = -77;
        int correctResult = targetMin + targetPreviousMin;

        int minValueInArray = -77;
        int maxValueInArray = 999;

        int[] randomArray1 = new int[]{targetMin, targetPreviousMin};

        int[] randomArray2 = testUtils.generateIntArray(3, minValueInArray, maxValueInArray);
        insertValuesInRandomPlaces(randomArray2, targetMin, targetPreviousMin);

        int[] randomArray3 = testUtils.generateIntArray(4, minValueInArray, maxValueInArray);
        insertValuesInRandomPlaces(randomArray3, targetMin, targetPreviousMin);

        int[] randomArray4 = testUtils.generateIntArray(5, minValueInArray, maxValueInArray);
        insertValuesInRandomPlaces(randomArray4, targetMin, targetPreviousMin);

        int[] randomArray5 = testUtils.generateIntArray(10_000_000, minValueInArray, maxValueInArray);
        insertValuesInRandomPlaces(randomArray5, targetMin, targetPreviousMin);

        return Stream.of(
            arguments(randomArray1, correctResult),
            arguments(randomArray2, correctResult),
            arguments(randomArray3, correctResult),
            arguments(randomArray4, correctResult),
            arguments(randomArray5, correctResult)
        );
    }

    private static void insertValuesInRandomPlaces(int[] array, int value1, int value2) {
        int randomArrayIndex1 = testUtils.generateRandomInteger(0, array.length - 1);
        int randomArrayIndex2 = testUtils.generateRandomInteger(0, array.length - 1);
        while (randomArrayIndex1 == randomArrayIndex2) {
            randomArrayIndex2 = testUtils.generateRandomInteger(0, array.length - 1);
        }
        array[randomArrayIndex1] = value1;
        array[randomArrayIndex2] = value2;
    }
}
