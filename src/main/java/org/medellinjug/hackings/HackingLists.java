package org.medellinjug.hackings;


import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.medellinjug.hackings.Utils.calculateTime;
import static org.medellinjug.hackings.Utils.populate;

public class HackingLists {
    public static Result addEnd(int amountData, int amountIterations) {
        long arrayListTime = 0;
        long linkedListTime = 0;
        int valueAdded = amountData / 2;

        for (int i = 1; i <= amountIterations; i++) {
            Collection<Integer> data = populate(amountData);

            ArrayList<Integer> arrayList = new ArrayList<>(
                    data);
            LinkedList<Integer> linkedList = new LinkedList<>(
                    data);

            arrayListTime += addToEnd(arrayList, valueAdded);
            linkedListTime += addToEnd(linkedList,
                    valueAdded);
        }

        return new Result(arrayListTime, linkedListTime);
    }

    private static long addToEnd(List<Integer> list,
                                 Integer value) {
        return calculateTime(() -> list
                .add(value));
    }

    public static Result addMiddle(int amountData, int amountIterations) {
        long arrayListTime = 0;
        long linkedListTime = 0;
        int valueAdded = amountData / 2;

        for (int i = 1; i <= amountIterations; i++) {
            Collection<Integer> data = populate(amountData);

            ArrayList<Integer> arrayList = new ArrayList<>(
                    data);
            LinkedList<Integer> linkedList = new LinkedList<>(
                    data);

            arrayListTime += addToMiddle(arrayList,
                    valueAdded);
            linkedListTime += addToMiddle(linkedList,
                    valueAdded);
        }

        return new Result(arrayListTime, linkedListTime);
    }

    private static long addToMiddle(List<Integer> list,
                                    Integer value) {
        return calculateTime(() -> list
                .add(value, value));
    }

    public static Result addStart(int amountData, int amountIterations) {
        long arrayListTime = 0;
        long linkedListTime = 0;
        int valueAdded = amountData / 2;

        for (int i = 1; i <= amountIterations; i++) {
            Collection<Integer> data = populate(amountData);

            ArrayList<Integer> arrayList = new ArrayList<>(
                    data);
            LinkedList<Integer> linkedList = new LinkedList<>(
                    data);

            arrayListTime += addToStart(arrayList,
                    valueAdded);
            linkedListTime += addToStart(linkedList,
                    valueAdded);
        }

        return new Result(arrayListTime, linkedListTime);
    }

    private static long addToStart(List<Integer> list,
                                   Integer value) {
        return calculateTime(() -> list
                .add(0, value));
    }

    public static Result deleteEnd(int amountData, int amountIterations) {
        long arrayListTime = 0;
        long linkedListTime = 0;

        for (int i = 1; i <= amountIterations; i++) {
            Collection<Integer> data = populate(amountData);

            ArrayList<Integer> arrayList = new ArrayList<>(
                    data);
            LinkedList<Integer> linkedList = new LinkedList<>(
                    data);

            arrayListTime += deleteFromEnd(arrayList);
            linkedListTime += deleteFromEnd(linkedList);
        }

        return new Result(arrayListTime, linkedListTime);
    }

    private static long deleteFromEnd(List<Integer> list) {
        return calculateTime(() -> list
                .remove(list.size() - 1));
    }

    public static Result deleteMiddle(int amountData, int amountIterations) {
        long arrayListTime = 0;
        long linkedListTime = 0;

        for (int i = 1; i <= amountIterations; i++) {
            Collection<Integer> data = populate(amountData);

            ArrayList<Integer> arrayList = new ArrayList<>(
                    data);
            LinkedList<Integer> linkedList = new LinkedList<>(
                    data);

            arrayListTime += deleteFromMiddle(arrayList);
            linkedListTime += deleteFromMiddle(linkedList);
        }

        return new Result(arrayListTime, linkedListTime);
    }

    private static long deleteFromMiddle(List<Integer> list) {
        return calculateTime(() -> list
                .remove(list.size() / 2));
    }

    public static Result deleteStart(int amountData, int amountIterations) {
        long arrayListTime = 0;
        long linkedListTime = 0;

        for (int i = 1; i <= amountIterations; i++) {
            Collection<Integer> data = populate(amountData);

            ArrayList<Integer> arrayList = new ArrayList<>(
                    data);
            LinkedList<Integer> linkedList = new LinkedList<>(
                    data);

            arrayListTime += deleteFromStart(arrayList);
            linkedListTime += deleteFromStart(linkedList);
        }

        return new Result(arrayListTime, linkedListTime);
    }

    private static long deleteFromStart(List<Integer> list) {
        return calculateTime(() -> list
                .remove(0));
    }

    public static Result getMiddle(int amountData, int amountIterations) {
        long arrayListTime = 0;
        long linkedListTime = 0;

        for (int i = 1; i <= amountIterations; i++) {
            Collection<Integer> data = populate(amountData);

            ArrayList<Integer> arrayList = new ArrayList<>(
                    data);
            LinkedList<Integer> linkedList = new LinkedList<>(
                    data);

            arrayListTime += getFromMiddle(arrayList);
            linkedListTime += getFromMiddle(linkedList);
        }

        return new Result(arrayListTime, linkedListTime);
    }

    private static long getFromMiddle(List<Integer> list) {
        return calculateTime(() -> list
                .get(list.size() / 2));
    }

    public static class Result {
        private final long arrayList;
        private final long linkedList;

        public Result(long arrayList, long linkedList) {
            this.arrayList = arrayList;
            this.linkedList = linkedList;
        }

        public long getArrayList() {
            return arrayList;
        }

        public long getLinkedList() {
            return linkedList;
        }
    }
}
