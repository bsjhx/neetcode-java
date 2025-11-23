package pl.bsjhx.katas.neetcode.coreskills.sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void name() {
        var sort = new InsertionSort();
        sort.insertionSort(
                new ArrayList<>(List.of(
                        new Pair(1, "aaa"),
                        new Pair(5, "aaa"),
                        new Pair(4, "aaa")
                ))
        );
    }
}