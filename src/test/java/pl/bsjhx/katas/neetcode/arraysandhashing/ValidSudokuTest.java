package pl.bsjhx.katas.neetcode.arraysandhashing;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.arraysandhashing.ValidSudoku;

import static org.junit.jupiter.api.Assertions.*;

class ValidSudokuTest {

    @Test
    void isValidSudoku() {
        ValidSudoku vs = new ValidSudoku();
        char[][] board = new char[][]
                {new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                ,new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                ,new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                ,new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                ,new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                ,new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                ,new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                ,new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                ,new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        assertTrue(vs.isValidSudoku(board));
    }
}