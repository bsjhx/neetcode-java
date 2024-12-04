package pl.bsjhx.katas.graphs.advanced;

import java.util.*;

class Dijkstra {
    // List.of(List.of(u, v, w), ...)
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, List<List<Integer>>> neighbours = new HashMap<>();

        for (List<Integer> neighbour : edges) {
            if (!neighbours.containsKey(neighbour.get(0))) {
                neighbours.put(neighbour.get(0), new ArrayList<>());
            }
            neighbours.get(neighbour.get(0)).add(List.of(neighbour.get(1), neighbour.get(2)));
        }

        Map<Integer, Integer> shortest = new HashMap<>();

        Queue<List<Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.get(0)));
        heap.add(List.of(0, src));

        while (!heap.isEmpty()) {
            List<Integer> polled = heap.poll();

            Integer node = polled.get(1);
            Integer weight = polled.get(0);
            if (shortest.containsKey(node)) {
                continue;
            }

            shortest.put(node, weight);

            for (List<Integer> nr : neighbours.getOrDefault(node, List.of())) {
                if (!shortest.containsKey(nr.get(0))) {
                    heap.add(List.of(weight + nr.get(1), nr.get(0)));
                }
            }

        }

        for (int i = 0; i < n; i++) {
            if (!shortest.containsKey(i)) {
                shortest.put(i, -1);
            }
        }

        return shortest;
    }
}
