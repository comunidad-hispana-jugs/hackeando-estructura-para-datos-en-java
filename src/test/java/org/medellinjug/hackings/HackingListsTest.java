package org.medellinjug.hackings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.medellinjug.hackings.Utils.calculateAverage;
import static org.medellinjug.hackings.Utils.printResults;


class HackingListsTest {
    @Test
    public void add_end() {
        long[] data = HackingLists.addEnd(10000000, 10);

        printResults("AddToEnd", data[0],
                data[1]);

        assertThat(calculateAverage(data[1]))
                .isLessThan(
                        calculateAverage(data[0]));
    }
}