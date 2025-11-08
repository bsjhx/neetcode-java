package pl.bsjhx.katas.neetcode.binarysearch;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.binarysearch.SearchMatrix;

import static org.junit.jupiter.api.Assertions.*;

class SearchMatrixTest {

    @Test
    void searchMatrix() {
        SearchMatrix sm = new SearchMatrix();

        int[][] a = new int[][]{new int[]{1, 3, 5, 7}, new int[]{10, 11, 16, 20}, new int[]{23, 30, 34, 60}};
        assertFalse(sm.searchMatrix(a, 13));
        assertTrue(sm.searchMatrix(a, 3));
    }
}