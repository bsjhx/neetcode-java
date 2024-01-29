package pl.bsjhx.graphs;

import java.util.*;

class PacificAtlanticWaterFlow {

    private Map<List<Integer>, Boolean> pacific;
    private Map<List<Integer>, Boolean> atlantic;

    private Set<List<Integer>> visited;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // pacific = r < 0 || c < 0
        // atlantic = r >= heights.length || c >= heights[0].length

        // if contains one of this - visited
        pacific = new HashMap<>();
        atlantic = new HashMap<>();
        visited = new HashSet<>();

        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                List<Integer> current = List.of(r, c);
                // if (!visited.contains(current)) {
                //     visited.add(current);
                bfs(heights, current);
                // }
            }
        }

        List<List<Integer>> result = new ArrayList<>(Math.max(atlantic.size(), pacific.size()));

        for (Map.Entry<List<Integer>, Boolean> p : pacific.entrySet()) {
            if (p.getValue() && atlantic.getOrDefault(p.getKey(), false)) {
                result.add(p.getKey());
            }
        }

        return result;

    }

    private void bfs(int[][] heights, List<Integer> starting) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(starting);
        visited = new HashSet<>();

        boolean isP = false, isA = false;

        while (!queue.isEmpty()) {
            List<Integer> current = queue.poll();
            // is pacific connected?
            Integer r = current.get(0);
            Integer c = current.get(1);

            // dol gora | prawo lewo
            List<List<Integer>> directions = List.of(List.of(1, 0), List.of(-1, 0), List.of(0, 1), List.of(0, -1));
            for (List<Integer> direction : directions) {
                int nr = r + direction.get(0);
                int nc = c + direction.get(1);

                if (nr < 0 || nc < 0) {
                    pacific.put(current, true);
                    isP = true;
                }

                if (nr >= heights.length || nc >= heights[0].length) {
                    atlantic.put(current, true);
                    isA = true;
                }

                List<Integer> nCurrent = List.of(nr, nc);

                // if in range and we can access neighbour (current value >= neighbour value)
                if (nr >= 0 && nr < heights.length &&
                        nc >= 0 && nc < heights[0].length &&
                        heights[r][c] >= heights[nr][nc]) {

                    if (pacific.containsKey(nCurrent)) {
                        pacific.put(current, true);
                        isP = true;
                    }

                    if (atlantic.containsKey(nCurrent)) {
                        atlantic.put(current, true);
                        isA = true;
                    }

                    if (!visited.contains(nCurrent)) {
                        queue.add(nCurrent);
                        visited.add(nCurrent);
                    }

                    if (isA && isP) {
                        break;
                    }
                }
            }
        }

        if (isP) {
            pacific.put(starting, true);
        }
        if (isA) {
            atlantic.put(starting, true);
        }
    }
}