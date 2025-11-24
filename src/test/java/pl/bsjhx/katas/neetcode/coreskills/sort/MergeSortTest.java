package pl.bsjhx.katas.neetcode.coreskills.sort;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void name() {
        var merge = new MergeSort();
        assertEquals(
                List.of(new Pair(6, "lolek"),
                        new Pair(7, "lolek")
                ),
                merge.mergeSort(List.of(
                        new Pair(7, "lolek"),
                        new Pair(6, "lolek")
                ))
        );
        assertEquals(
                List.of(new Pair(1, "lolek"),
                        new Pair(6, "lolek"),
                        new Pair(9, "lolek"),
                        new Pair(19, "lolek")
                ),
                merge.mergeSort(List.of(
                        new Pair(9, "lolek"),
                        new Pair(1, "lolek"),
                        new Pair(19, "lolek"),
                        new Pair(6, "lolek")
                ))
        );
        assertEquals(
                List.of(new Pair(1, "lolek"),
                        new Pair(6, "lolek"),
                        new Pair(9, "lolek"),
                        new Pair(19, "lolek"),
                        new Pair(66, "lolek")
                ),
                merge.mergeSort(List.of(
                        new Pair(9, "lolek"),
                        new Pair(1, "lolek"),
                        new Pair(19, "lolek"),
                        new Pair(6, "lolek"),
                        new Pair(66, "lolek")
                ))
        );
        assertEquals(
                List.of(new Pair(1, "lolek"),
                        new Pair(6, "lolek"),
                        new Pair(6, "abcd"),
                        new Pair(9, "lolek"),
                        new Pair(19, "lolek"),
                        new Pair(66, "lolek")
                ),
                merge.mergeSort(List.of(
                        new Pair(9, "lolek"),
                        new Pair(1, "lolek"),
                        new Pair(19, "lolek"),
                        new Pair(6, "lolek"),
                        new Pair(6, "abcd"),
                        new Pair(66, "lolek")
                ))
        );
    }
}