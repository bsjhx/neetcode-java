package pl.bsjhx.graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class IslandsAndTreasure {
    public void islandsAndTreasure(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    Set<List<Integer>> visited = new HashSet<>();
                    dps(grid, r, c, 0, visited);
                }
            }
        }
    }

    private void dps(int[][] grid, int r, int c, int distance, Set<List<Integer>> visited) {
        // visited.add(List.of(r, c));
        if (grid[r][c] > distance) {
            grid[r][c] = distance;
        }

        int[][] directions = new int[][]{new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}};

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < grid.length &&
                    nc >= 0 && nc < grid[0].length &&
                    grid[nr][nc] > distance) {
                dps(grid, nr, nc, distance + 1, visited);
            }
        }
    }

}
