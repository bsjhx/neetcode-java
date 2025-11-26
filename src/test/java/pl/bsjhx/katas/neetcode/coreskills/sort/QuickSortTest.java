package pl.bsjhx.katas.neetcode.coreskills.sort;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void name() {
        var merge = new QuickSort();
        assertEquals(
                List.of(new Pair(6, "lolek"),
                        new Pair(7, "lolek")
                ),
                merge.quickSort(List.of(
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
                merge.quickSort(List.of(
                        new Pair(9, "lolek"),
                        new Pair(1, "lolek"),
                        new Pair(19, "lolek"),
                        new Pair(6, "lolek")
                ))
        );
    }
}