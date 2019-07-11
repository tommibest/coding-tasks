package com.zaras.parallel;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class ParallelSorting {
    public static void main(String[] args) {
        int[] numbers = ThreadLocalRandom.current().ints(100_000_000).toArray();
        for (int i = 0; i < 10; i++) {

            testSort(numbers);
        }
    }

    private static void testSort(int[] numbers) {
        int[] numbersSeq = numbers.clone();
        int[] numbersPar = numbers.clone();

        sort("seq", numbersSeq, Arrays::sort);
        sort("par", numbersPar, Arrays::parallelSort);
    }

    private static void sort(String description, int[] numbers, Consumer<int[]> sortAlgorithm) {
        long time = System.currentTimeMillis();
        try {
            sortAlgorithm.accept(numbers);
        } finally {
            time = System.currentTimeMillis() - time;
            System.out.println(description + " time = " + time + "ms");
        }
    }
}
