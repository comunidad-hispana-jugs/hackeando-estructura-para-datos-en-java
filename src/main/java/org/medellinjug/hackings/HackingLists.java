package org.medellinjug.hackings;


import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.medellinjug.hackings.Utils.calculateTime;
import static org.medellinjug.hackings.Utils.populate;

public class HackingLists {
    public static long[] addEnd(int amountData, int amountIterations) {
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

        return new long[]{arrayListTime, linkedListTime};
    }

    private static long addToEnd(List<Integer> list,
                                 Integer value) {
        return calculateTime(() -> list
                .add(value));
    }
}
