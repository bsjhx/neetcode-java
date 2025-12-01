package pl.bsjhx.katas.adventofcode.year2024;


import pl.bsjhx.katas.adventofcode.Advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Day7Of2024 implements Advent {

    public long calculatePartOne() throws IOException {
        var r = readFromFile();
        return r.entrySet()
                .stream()
                .mapToLong(e -> helper(e.getValue(), e.getKey(), 0, 0L))
                .sum();
    }

    public long calculatePartTwo() throws IOException {
        var r = readFromFile();
        return r.entrySet()
                .stream()
                .mapToLong(e -> helper2(e.getValue(), e.getKey(), 0, 0L))
                .sum();
    }

    private long helper(final List<Long> values, final long targetValue, int i, long currentValue) {
        if (i == values.size()) {
            return currentValue == targetValue ? currentValue : 0;
        }
        
        if (currentValue > targetValue) {
            return 0;
        }
        
        var newValue = values.get(i);

        long sumValue = helper(values, targetValue, i + 1, currentValue + newValue);
        if (sumValue != targetValue) {
            return helper(values, targetValue, i + 1, currentValue * newValue);
        } else {
            return sumValue;
        }
    }

    private long helper2(final List<Long> values, final long targetValue, int i, long currentValue) {
        if (i == values.size()) {
            return currentValue == targetValue ? currentValue : 0;
        }

        if (currentValue > targetValue) {
            return 0;
        }

        var newValue = values.get(i);

        long sumValue = helper2(values, targetValue, i + 1, currentValue + newValue);

        if (sumValue == targetValue) {
            return sumValue;
        }
        
        var s = currentValue + String.valueOf(newValue);
        var togetherValue =  helper2(values, targetValue, i + 1, Long.parseLong(s));

        if (togetherValue == targetValue) {
            return togetherValue;
        }
        
        long multiplyValue = helper2(values, targetValue, i + 1, currentValue * newValue);

        if (multiplyValue == targetValue) {
            return multiplyValue;
        }
        
        return 0;
    }

    private Map<Long, List<Long>> readFromFile() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2024/day7.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            Map<Long, List<Long>> result = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                String[] split = line.split(":");
                result.computeIfAbsent(Long.parseLong(split[0]), (k) ->
                        Arrays.stream(split[1].split(" ")).filter(s -> !"".equals(s)).map(Long::parseLong).toList()
                );
            }

             return result;
        }
    }

}
