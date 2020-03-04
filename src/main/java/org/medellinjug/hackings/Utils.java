package org.medellinjug.hackings;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

public class Utils {
    public static Collection<Integer> populate(
            int amount) {
        return new Random()
                .ints()
                .limit(amount)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void printResults(String operation,
                                    long arrayListTime,
                                    long linkedListTime, int amountData, int amountIterations) {
        System.out.println(
                "[" + operation + "] Amount Data: " + amountData);
        System.out.println(
                "[" + operation + "] Amount Iterations: " + amountIterations);
        System.out.println(
                "[" + operation + "] Average ArrayList (ms): " + calculateAverage(
                        arrayListTime, amountIterations));
        System.out.println(
                "[" + operation + "] Average LinkedList (ms): " + (calculateAverage(
                        linkedListTime, amountIterations)));
    }

    public static float calculateAverage(
            long totalTime, int amountIterations) {
        return totalTime / (float) amountIterations;
    }

    public static long calculateTime(Runnable runnable) {
        long start = System.nanoTime();
        runnable.run();
        long end = System.nanoTime();
        return (end - start) / 1000000;
    }
}
