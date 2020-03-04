package org.medellinjug.hackings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.medellinjug.hackings.Utils.calculateAverage;
import static org.medellinjug.hackings.Utils.printResults;


class HackingListsTest {
    @Test
    public void add_end() {
        HackingLists.Result data = HackingLists.addEnd(10000000, 10);

        printResults("AddToEnd", data.getArrayList(),
                data.getLinkedList(), 10000000, 10);

        assertThat(calculateAverage(data.getLinkedList(), 10))
                .isLessThan(
                        calculateAverage(data.getArrayList(), 10));
    }

    @Test
    public void add_middle() {
        HackingLists.Result data = HackingLists.addMiddle(10000000, 10);

        printResults("AddToMiddle", data.getArrayList(),
                data.getLinkedList(), 10000000, 10);

        assertThat(calculateAverage(data.getLinkedList(), 10))
                .isLessThan(
                        calculateAverage(data.getArrayList(), 10));
    }

    @Test
    public void add_start() {
        HackingLists.Result data = HackingLists.addStart(10000000, 10);

        printResults("AddToStart", data.getArrayList(),
                data.getLinkedList(), 10000000, 10);

        assertThat(calculateAverage(data.getLinkedList(), 10))
                .isLessThan(
                        calculateAverage(data.getArrayList(), 10));
    }

    @Test
    public void delete_end() {
        HackingLists.Result data = HackingLists.deleteEnd(10000000, 10);

        printResults("DeleteFromEnd", data.getArrayList(),
                data.getLinkedList(), 10000000, 10);

        assertThat(calculateAverage(data.getLinkedList(), 10))
                .isEqualTo(0);

        assertThat(calculateAverage(data.getArrayList(), 10))
                .isEqualTo(0);
    }

    @Test
    public void delete_middle() {
        HackingLists.Result data = HackingLists.deleteMiddle(10000000, 10);

        printResults("DeleteFromMiddle", data.getArrayList(),
                data.getLinkedList(), 10000000, 10);

        assertThat(calculateAverage(data.getLinkedList(), 10))
                .isLessThan(
                        calculateAverage(data.getArrayList(), 10));
    }

    @Test
    public void delete_start() {
        HackingLists.Result data = HackingLists.deleteStart(10000000, 10);

        printResults("DeleteFromStart", data.getArrayList(),
                data.getLinkedList(), 10000000, 10);

        assertThat(calculateAverage(data.getLinkedList(), 10))
                .isLessThan(
                        calculateAverage(data.getArrayList(), 10));
    }

    @Test
    public void get_middle() {
        HackingLists.Result data = HackingLists.getMiddle(10000000, 10);

        printResults("GetFromMiddle", data.getArrayList(),
                data.getLinkedList(), 10000000, 10);

        assertThat(calculateAverage(data.getArrayList(), 10))
                .isLessThan(
                        calculateAverage(data.getLinkedList(), 10));
    }
}