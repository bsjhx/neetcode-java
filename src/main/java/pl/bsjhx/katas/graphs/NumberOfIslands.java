package pl.bsjhx.katas.graphs;

import java.util.*;

class NumberOfIslands {

    private static final List<int[]> DIRECTIONS = List.of(new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1});

    private Set<List<Integer>> visited;
    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        visited = new HashSet<>();

        int result = 0;
        rows = grid.length;
        cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited.contains(List.of(i, j))) {
                    bfs(i, j, grid);
                    result++;
                }
            }
        }

        return result;
    }

    public int numIslandsDFS(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }

        return result;
    }

    private void bfs(int r, int c, char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        visited.add(List.of(r, c));
        queue.add(new int[]{r, c});

        while (!queue.isEmpty()) {
            int[] currPos = queue.poll();
            for (int[] dir : DIRECTIONS) {
                int newRow = currPos[0] + dir[0];
                int newCol = currPos[1] + dir[1];
                if (newRow >= 0 &&
                        newRow <= rows &&
                        newCol >= 0 &&
                        newCol <= cols &&
                        !visited.contains(List.of(newRow, newCol)) &&
                        grid[newRow][newCol] == '1') {
                    visited.add(List.of(newRow, newCol));
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

}