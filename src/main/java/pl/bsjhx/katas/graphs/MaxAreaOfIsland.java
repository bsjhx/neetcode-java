package pl.bsjhx.katas.graphs;

class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[0].length ; j++) {
                if (grid[i][j] == 1) {
                    result = Math.max(dfs(grid, i, j, 0), result);
                }
            }
        }

        return result;        
    }

    private int dfs(int [][] grid, int r, int c, int currentArea) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        currentArea = 1 +dfs(grid, r + 1, c, currentArea) +
        dfs(grid, r - 1, c, currentArea) +
        dfs(grid, r, c + 1, currentArea) +
        dfs(grid, r, c - 1, currentArea);

        return currentArea;
    }
}