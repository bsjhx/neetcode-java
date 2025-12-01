package pl.bsjhx.katas.adventofcode.year2024;


import pl.bsjhx.katas.adventofcode.Advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Day2Of2024 implements Advent {

    public long calculatePartOne() throws IOException {
        var data = readFromFile();
        return data.stream().map(Day2Of2024::validateRow)
                .filter(v -> v == 1)
                .count();
    }

    public long calculatePartTwo() throws IOException {
        var data = readFromFile();
        return data.stream().map(v -> {
                    var prev = -1;
                    var diff = v.get(0) - v.get(1) > 0 ? -1 : 1;
                    for (var i = 0 ; i < v.size() ; i++) {
                        if (prev == -1) {
                            if (validateRow(v, 0) == 0) {
                                prev = v.get(i + 1);
                                continue;
                            }

                            prev = v.get(i);
                            continue;
                        }

                        if (Math.abs(prev - v.get(i)) > 3) {
                            return validateRow(v, i);
                        }

                        if (prev == v.get(i)) {
                            return validateRow(v, i);
                        }

                        if (prev - v.get(i) > 0 && diff == 1) {
                            return validateRow(v, i);
                        }

                        if (prev - i < 0 && diff == -1) {
                            return validateRow(v, i);
                        }

                        prev = v.get(i);
                    }
                    return 1;
                })
                .filter(v -> v == 1)
                .count();
    }

    private static int validateRow(List<Integer> v) {
        return validateRow(v, -1);
    }

    private static int validateRow(List<Integer> v, Integer toSkip) {
        var prev = -1;
        var diff = v.get(0) - v.get(1) > 0 ? -1 : 1;
        for (var i = 0 ; i < v.size() ; i++) {
            if (toSkip == i) {
                continue;
            }

            if (prev == -1) {
                prev = v.get(i);
                continue;
            }

            if (Math.abs(prev - v.get(i)) > 3) {
                return 0;
            }

            if (prev == v.get(i)) {
                return 0;
            }

            if (prev - v.get(i) > 0 && diff == 1) {
                return 0;
            }

            if (prev - v.get(i) < 0 && diff == -1) {
                return 0;
            }

            prev = v.get(i);
        }
        return 1;
    }

    private List<List<Integer>> readFromFile() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2024/day2.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            List<List<Integer>> result = new ArrayList<>(1000);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                result.add(Arrays.stream(parts).map(Integer::parseInt).toList());
            }

            return result;
        }
    }
}
