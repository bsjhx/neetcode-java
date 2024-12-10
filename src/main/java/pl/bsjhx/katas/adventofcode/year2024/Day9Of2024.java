package pl.bsjhx.katas.adventofcode.year2024;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Day9Of2024 implements Advent {

    public long calculatePartOne() throws IOException {
        var r = readFromFile();

        List<Integer> list = Arrays.stream(r.split("")).map(Integer::parseInt).toList();
        Deque<Integer> spaces = new ArrayDeque<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i); j++) {
                if (i % 2 == 0) {
                    spaces.add(i / 2);
                } else {
                    spaces.add(-1);
                }
            }
        }

        var result = 0L;
        var i = 0L;
        while (!spaces.isEmpty()) {
            if (spaces.peekFirst() != -1) {
                result += i * spaces.pollFirst();
            } else {
                spaces.pollFirst();
                while (!spaces.isEmpty() && spaces.peekLast() == -1) {
                    spaces.pollLast();
                }
                if (spaces.isEmpty()) {
                    return result;
                }
                result += i * spaces.pollLast();
            }
            i++;
        }

        return result;
    }

    public long calculatePartTwo() throws IOException {
        return 0;
    }

    private String readFromFile() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2024/day9.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            return reader.readLine();
        }
    }

}
