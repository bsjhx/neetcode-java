package pl.bsjhx.katas.adventofcode.year2025;

import pl.bsjhx.katas.adventofcode.Advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Day01_2025 implements Advent {

    @Override
    public long calculatePartOne() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day1.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            Map<String, Queue<Long>> resultMap = new HashMap<>();
            resultMap.put("L", new PriorityQueue<>());
            resultMap.put("R", new PriorityQueue<>());

            String line;
            var result = 50;
            var counter = 0;
            while ((line = reader.readLine()) != null) {
                var direction = line.substring(0, 1);
                var number = Integer.parseInt(line.substring(1));

                if ("R".equals(direction)) {
                    // +
                    number %= 100;
                    result += number;

                    if (result > 99) {
                        result = result % 100;
                    }
                } else {
                    // -
                    number %= 100;
                    result -= number;
                    if (result < 0) {
                        result = 100 + result;
                    }
                }
                if (result == 0) {
                    counter++;
                }
            }

            return counter;
        }
    }

    @Override
    public long calculatePartTwo() throws IOException {
        return Advent.super.calculatePartTwo();
    }

    private Map<String, Queue<Long>> readFromFile() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day1.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            Map<String, Queue<Long>> resultMap = new HashMap<>();
            resultMap.put("L", new PriorityQueue<>());
            resultMap.put("R", new PriorityQueue<>());

            String line;
            while ((line = reader.readLine()) != null) {
                var direction = line.substring(0, 1);
                var number = Integer.parseInt(line.substring(1));
            }

            return resultMap;
        }
    }
}
