package pl.bsjhx.katas.adventofcode.year2024;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Day1Of2024 {

    public static void main(String[] args) throws IOException {
        var day1 = new Day1Of2024();
        System.out.printf("Day 1, part 1 result %s%n", day1.calculate());
        System.out.printf("Day 1, part 2 result %s%n", day1.calculate2());
    }
    
    long calculate() throws IOException {
        var data = readFromFile();
        var result = 0L;
        
        while (!data.get("L").isEmpty()) {
            Long l = data.get("L").poll();
            Long r = data.get("R").poll();
            result += Math.abs(l - r);
        }
        
        return result;
    }
    
    long calculate2() throws IOException {
        var data = readFromFile2();
        return data.l.stream()
                .mapToLong(el -> Long.parseLong(el) * data.r.getOrDefault(el, 0L))
                .sum();
    }

    Map<String, Queue<Long>> readFromFile() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2024/day1.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            Map<String, Queue<Long>> resultMap = new HashMap<>();
            resultMap.put("L", new PriorityQueue<>());
            resultMap.put("R", new PriorityQueue<>());

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                resultMap.get("L").add(Long.parseLong(parts[0]));
                resultMap.get("R").add(Long.parseLong(parts[1]));
            }

            return resultMap;
        }
    }
    
    record Pair(List<String> l, Map<String, Long> r){};

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
