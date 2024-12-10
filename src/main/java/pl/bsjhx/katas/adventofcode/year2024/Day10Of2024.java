package pl.bsjhx.katas.adventofcode.year2024;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Day10Of2024 implements Advent {

    public static final List<List<Integer>> DIRECTIONS = List.of(
            List.of(-1, 0), // UP
            List.of(0, 1), // RIGHT
            List.of(1, 0), // DOWN
            List.of(0, -1)  // LEFT
    );

    public long calculatePartOne() throws IOException {
        var r = readFromFile();
        var result = 0;

        for (int i = 0; i < r.size(); i++) {
            for (int j = 0; j < r.getFirst().size(); j++) {
                var current = r.get(i).get(j);
                if ("0".equals(current)) {
                    Set<List<Integer>> peeks = new HashSet<>();
                    helper(r, i, j, peeks);
                    result += peeks.size();
                }
            }
        }


        return result;
    }

    private void helper(List<List<String>> r, int i, int j, Set<List<Integer>> peeks) {
        if ("9".equals(r.get(i).get(j))) {
            peeks.add(List.of(i, j));
            return;
        }
        
        for (var dir : DIRECTIONS) {
            var newI = i + dir.getFirst();
            var newJ = j + dir.getLast();
            
            if (isInMap(newI, newJ, r)) {
                var currentHigh = Integer.parseInt(r.get(i).get(j));
                var nextHigh = Integer.parseInt(r.get(newI).get(newJ));
                if (nextHigh - currentHigh == 1) {
                    helper(r, newI, newJ, peeks);
                }
            }
        }
    }

    public long calculatePartTwo() throws IOException {
        return 0;
    }

    private List<List<String>> readFromFile() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2024/day10.txt");
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

    private static boolean isInMap(Integer i, Integer j, final List<List<String>> map) {
        return i >= 0 && j >= 0 && i < map.size() && j < map.getFirst().size();
    }
}
