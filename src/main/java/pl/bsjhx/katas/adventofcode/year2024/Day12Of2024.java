package pl.bsjhx.katas.adventofcode.year2024;


import pl.bsjhx.katas.adventofcode.Advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Day12Of2024 implements Advent {

    public long calculatePartOne() throws IOException {
        var data = readFromFile();

        Set<List<Integer>> visited = new HashSet<>();
        var result = 0;

        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.getFirst().size(); j++) {
                if (!visited.contains(List.of(i, j))) {
                    visited.add(List.of(i, j));
                    var type = data.get(i).get(j);
                    result += bfs(data, type, i, j, visited);
                }
            }

        }

        return result;
    }

    private int bfs(List<List<String>> data, String type, int i, int j, Set<List<Integer>> visited) {
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(List.of(i, j));
        Set<List<Integer>> bl = new HashSet<>();
        var bll = 0;
        var c = 0;

        while (!q.isEmpty()) {
            var node = q.poll();
            c++;

            for (var dir : DIRECTIONS) {
                var newI = node.getFirst() + dir.getFirst();
                var newJ = node.getLast() + dir.getLast();

                if (Advent.isInMap(newI, newJ, data)) {
                    if (data.get(newI).get(newJ).equals(type) && !visited.contains(List.of(newI, newJ))) {
                        q.add(List.of(newI, newJ));
                        visited.add(List.of(newI, newJ));
                    }
                    if (!data.get(newI).get(newJ).equals(type)) {
                        bl.add(List.of(newI, newJ));
                        bll++;
                    }
                } else {
                    bl.add(List.of(newI, newJ));
                    bll++;
                }
            }
        }

        System.out.printf(
                "Type: %s | c: %s | bl %s | c*bl %s%n", type, c, bll, c * bll
        );
        return c * bll;
    }

    public long calculatePartTwo() throws IOException {
        return 0;
    }

    private List<List<String>> readFromFile() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2024/day12.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            List<List<String>> result = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("");
                result.add(Arrays.stream(parts).toList());
            }

            return result;
        }
    }

}
