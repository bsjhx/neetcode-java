package pl.bsjhx.graphs;

import java.util.*;

class SurroundedRegions {

    private Set<List<Integer>> visited;

    public void solve(char[][] board) {
        visited = new HashSet<>();

        for (int r = 0; r < board.length; r++) {
            if (!visited.contains(List.of(r, 0)) && board[r][0] == 'O') {
                bfs(board, r, 0);
                // visited.add(List.of(r, 0));
            }
            if (!visited.contains(List.of(r, board[0].length - 1)) && board[r][board[0].length - 1] == 'O') {
                bfs(board, r, board[0].length - 1);
            }
        }

        for (int c = 0; c < board[0].length; c++) {
            if (!visited.contains(List.of(0, c)) && board[0][c] == 'O') {
                bfs(board, 0, c);
            }
            if (!visited.contains(List.of(board.length - 1, c)) && board[board.length - 1][c] == 'O') {
                bfs(board, board.length - 1, c);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited.contains(List.of(i, j))) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void bfs(char[][] board, int r, int c) {
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> current = List.of(r, c);
        queue.add(current);
        visited.add(current);

        while (!queue.isEmpty()) {
            current = queue.poll();
            List<List<Integer>> directions = List.of(List.of(1, 0), List.of(-1, 0), List.of(0, 1), List.of(0, -1));

            for (List<Integer> dir : directions) {
                int nr = current.get(0) + dir.get(0), nc = current.get(1) + dir.get(1);

                List<Integer> neighbour = List.of(nr, nc);
                if (nr >= 0 && nr < board.length &&
                        nc >= 0 && nc < board[0].length &&
                        !visited.contains(neighbour) &&
                        board[nr][nc] == 'O'
                ) {
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }
    }
}