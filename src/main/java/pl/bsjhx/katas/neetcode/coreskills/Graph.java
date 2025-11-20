package pl.bsjhx.katas.neetcode.coreskills;

import java.util.*;

class Graph {

    private final Map<Integer, Set<Integer>> graph = new HashMap<>();

    public Graph() {

    }

    public void addEdge(int src, int dst) {
        graph.computeIfAbsent(src, k -> new HashSet<>()).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (!graph.containsKey(src)) {
            return false;
        }

        Set<Integer> destinations = graph.get(src);
        return destinations.remove(dst);

    }

    public boolean hasPath(int src, int dst) {
        if (!graph.containsKey(src)) {
            return false;
        }

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> next = new Stack<>();
        next.add(src);
        next.addAll(graph.get(src));

        while (!next.isEmpty()) {
            var currentNode = next.pop();
            if (visited.contains(currentNode)) {
                continue;
            }
            visited.add(currentNode);
            var neighbours = graph.get(currentNode);

            if (neighbours == null || neighbours.isEmpty()) {
                continue;
            }

            if (neighbours.contains(dst)) {
                return true;
            }

            for (int neighbour : neighbours) {
                if (!visited.contains(neighbour)) {
                    next.add(neighbour);
                }
            }
        }

        return false;
    }
}