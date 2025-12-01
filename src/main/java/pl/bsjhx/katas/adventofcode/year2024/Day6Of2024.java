package pl.bsjhx.katas.adventofcode.year2024;


import pl.bsjhx.katas.adventofcode.Advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Day6Of2024 implements Advent {

    private final Map<List<Integer>, List<Integer>> directions = Map.of(
            List.of(-1, 0), List.of(0, 1),
            List.of(0, 1), List.of(1, 0),
            List.of(1, 0), List.of(0, -1),
            List.of(0, -1), List.of(-1, 0)
    );

    public long calculatePartOne() throws IOException {
        var fromFile = readFromFile();

        var i = fromFile.startingPosition.getFirst();
        var j = fromFile.startingPosition.get(1);

        var map = fromFile.map;
        Set<List<Integer>> visited = new HashSet<>();
        List<Integer> currentDir = List.of(-1, 0);
        while (true) {
            visited.add(List.of(i, j));
            var nextI = i + currentDir.getFirst();
            var nextJ = j + currentDir.getLast();
            if (!isInMap(nextI, nextJ, map)) {
                return visited.size();
            }

            if ("#".equals(map.get(nextI).get(nextJ))) {
                currentDir = directions.get(currentDir);
                i += currentDir.getFirst();
                j += currentDir.getLast();
            } else {
                i = nextI;
                j = nextJ;
            }
        }
    }

    private static boolean isInMap(List<Integer> pos, final List<List<String>> map) {
        return isInMap(pos.getFirst(), pos.getLast(), map);
    }

    private static boolean isInMap(Integer i, Integer j, final List<List<String>> map) {
        return i >= 0 && j >= 0 && i < map.size() && j < map.getFirst().size();
    }

    public long calculatePartTwo() throws IOException {
        return 0;
    }

    private FromFile readFromFile() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2024/day6.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            List<List<String>> map = new ArrayList<>();
            int i = 0, j = 0;
            List<Integer> startingPosition = List.of();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("");
                map.add(Arrays.stream(parts).toList());

                if (line.contains("^")) {
                    j = line.split("\\^")[0].length();
                    startingPosition = List.of(i, j);
                }
                i++;
            }

            return new FromFile(startingPosition, map);
        }
    }

    record FromFile(List<Integer> startingPosition, List<List<String>> map) {
    }
}
