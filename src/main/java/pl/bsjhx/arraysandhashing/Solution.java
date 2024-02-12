package pl.bsjhx.arraysandhashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rows = new HashSet<>();
        Set<Character> cols = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!rows.add(board[i][j])) {
                        return false;
                    }
                }
                if (board[j][i] != '.') {
                    if (!cols.add(board[j][i])) {
                        return false;
                    }
                }

                if (i % 3 == 0 && j % 3 == 0) {
                    Set<Character> sqrt = new HashSet<>();
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            if (board[k][l] != '.') {
                                if (!sqrt.add(board[k][l])) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            rows = new HashSet<>();
            cols = new HashSet<>();
        }

        return true;
        
    }
}