package pl.bsjhx.katas.neetcode.graphs;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.graphs.NumberOfIslands;

class NumberOfIslandsTest {

    @Test
    void numIslands() {
        NumberOfIslands noi = new NumberOfIslands();
        char[][] a = new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}
        };
        System.out.println(noi.numIslands(a));
        System.out.println(noi.numIslandsDFS(a));
    }
}