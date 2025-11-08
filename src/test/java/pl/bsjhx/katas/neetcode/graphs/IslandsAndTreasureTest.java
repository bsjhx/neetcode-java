package pl.bsjhx.katas.neetcode.graphs;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.graphs.IslandsAndTreasure;

import java.util.Arrays;

class IslandsAndTreasureTest {

    @Test
    void islandsAndTreasure() {
        IslandsAndTreasure iat = new IslandsAndTreasure();
        int[][] grid = new int[][]{
                new int[]{2147483647,-1,0,2147483647},
                new int[]{2147483647,2147483647,2147483647,-1},
                new int[]{2147483647,-1,2147483647,-1},
                new int[]{0,-1,2147483647,2147483647},
        };
        iat.islandsAndTreasure(grid);

        System.out.println(Arrays.deepToString(grid));
    }
}