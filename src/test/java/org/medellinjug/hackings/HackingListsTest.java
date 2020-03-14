package org.medellinjug.hackings;

import org.junit.jupiter.api.Test;


class HackingListsTest {
    @Test
    public void add_end() {
        HackingLists.Result result = HackingLists.addEnd(10_000_000, 5);
        Utils.printResults( "AddToEnd", result.getTimeArrayList(), result.getTimeLinkedList(), 10000000);
    }

    @Test
    public void add_middle() {
        HackingLists.Result result = HackingLists.addMiddle(10000000, 1);
        Utils.printResults( "AddToMiddle", result.getTimeArrayList(), result.getTimeLinkedList(), 10000000);
    }

    @Test
    public void add_start() {
        HackingLists.Result result = HackingLists.addStart(10000000, 1);
        Utils.printResults( "AddToStart", result.getTimeArrayList(), result.getTimeLinkedList(), 10000000);

    }

    @Test
    public void delete_end() {
        HackingLists.Result result = HackingLists.deleteEnd(10000000);
        Utils.printResults( "DeleteFromEnd", result.getTimeArrayList(), result.getTimeLinkedList(), 10000000);
    }

    @Test
    public void delete_middle() {
        HackingLists.Result result = HackingLists.deleteMiddle(10000000);
        Utils.printResults( "DeleteFromMiddle", result.getTimeArrayList(), result.getTimeLinkedList(), 10000000);
    }

    @Test
    public void delete_start() {
        HackingLists.Result result = HackingLists.deleteStart(10000000);
        Utils.printResults( "DeleteFromStart", result.getTimeArrayList(), result.getTimeLinkedList(), 10000000);
    }

    @Test
    public void getFromPosition() {
        HackingLists.Result result = HackingLists.getFromPosition(10_000_000, 10_000_000/2);
        Utils.printResults( "GetFromPosition", result.getTimeArrayList(), result.getTimeLinkedList(), 10000000);
    }
}