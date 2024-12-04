package pl.bsjhx.katas.graphs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PacificAtlanticWaterFlowTest {

    @Test
    void pacificAtlantic() {
        PacificAtlanticWaterFlow pawf = new PacificAtlanticWaterFlow();
        // int[][] h = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        int[][] h = new int[][]{{2, 1}, {1, 2}};
        List<List<Integer>> lists = pawf.pacificAtlantic(h);
        System.out.println(lists);
    }
}