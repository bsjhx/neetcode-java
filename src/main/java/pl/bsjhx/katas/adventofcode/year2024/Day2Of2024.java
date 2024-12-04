package pl.bsjhx.katas.adventofcode.year2024;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Day2Of2024 {

    public static void main(String[] args) throws IOException {
        var day2 = new Day2Of2024();
        System.out.printf("Day 2, part 1 result %s%n", day2.calculate());
        System.out.printf("Day 1, part 2 result %s%n", day2.calculate2());
    }

    long calculate() throws IOException {
        var data = readFromFile();


        return data.stream().map(v -> {
                    var prev = -1;
                    var diff = v.get(0) - v.get(1) > 0 ? -1 : 1;
                    for (var i : v) {
                        if (prev == -1) {
                            prev = i;
                            continue;
                        }

                        if (Math.abs(prev - i) > 3) {
                            return 0;
                        }

                        if (prev == i) {
                            return 0;
                        }

                        if (prev - i > 0 && diff == 1) {
                            return 0;
                        }

                        if (prev - i < 0 && diff == -1) {
                            return 0;
                        }
                        
                        prev = i;
                    }
                    return 1;
                })
                .filter(v -> v == 1)
                .count();
    }

    long calculate2() throws IOException {
        var data = readFromFile2();
        return data.l.stream()
                .mapToLong(el -> Long.parseLong(el) * data.r.getOrDefault(el, 0L))
                .sum();
    }

    List<List<Integer>> readFromFile() throws IOException {
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

    record Pair(List<String> l, Map<String, Long> r) {
    }

    ;

    Pair readFromFile2() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2024/day1.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            Map<String, Long> resultMap = new HashMap<>();
            List<String> resultList = new ArrayList<>(1000);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                var s = parts[1];
                resultList.add(parts[0]);
                resultMap.compute(s, (k, v) -> {
                    if (v == null) {
                        return 1L;
                    } else {
                        return v + 1;
                    }
                });
            }

            return new Pair(resultList, resultMap);
        }
    }


}
