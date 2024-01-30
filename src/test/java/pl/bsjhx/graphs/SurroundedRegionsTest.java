package pl.bsjhx.graphs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SurroundedRegionsTest {

    @Test
    void solve() {
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        // surroundedRegions.solve(board);
        // System.out.println(Arrays.deepToString(board));

        // board = new char[][]{{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        // surroundedRegions.solve(board);
        // System.out.println(Arrays.deepToString(board));

        board = new char[][]{{'X','O','X','O','X','O'},
        {'O','X','X','X','X','X'},
        {'X','X','X','X','X','O'},
        {'O','X','O','X','O','X'}};
        surroundedRegions.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}