package pl.bsjhx.katas.adventofcode.year2025;

import pl.bsjhx.katas.adventofcode.Advent;
import pl.bsjhx.katas.adventofcode.common.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Day09_2025 implements Advent {

    @Override
    public long calculatePartOne() throws IOException {
        long res = 0L;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day9.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;

            Pair<Long, Long> min = Pair.of(100000L, 100000L);
            Pair<Long, Long> max = Pair.of(0L, 0L);
            while ((line = reader.readLine()) != null) {
                List<Long> list = Arrays.stream(line.split(","))
                        .map(Long::parseLong)
                        .toList();
                var currDis = list.getFirst() * list.getFirst() + list.getLast() * list.getLast();
                var minDis = min.first() * min.first() + min.second() * min.second();
                var maxDis = max.first() * max.first() + max.second() * max.second();
                if (currDis < minDis) {
                    min = Pair.of(list.getFirst(), list.getLast());
                }
                if (currDis > maxDis) {
                    max = Pair.of(list.getFirst(), list.getLast());
                }
            }
            res = (Math.abs(min.first() - max.first()) + 1) * (Math.abs(min.second() - max.second()) + 1);

        }
        return res;
    }

    @Override
    public long calculatePartTwo() throws IOException {
        return Advent.super.calculatePartOne();
    }
}
