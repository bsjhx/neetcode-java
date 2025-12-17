package pl.bsjhx.katas.adventofcode.year2025;

import pl.bsjhx.katas.adventofcode.Advent;
import pl.bsjhx.katas.adventofcode.common.MultiRange;
import pl.bsjhx.katas.adventofcode.common.Range;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day05_2025 implements Advent {

    @Override
    public long calculatePartOne() throws IOException {
        long res = 0;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day5.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            List<List<Long>> result = new ArrayList<>();
            List<Long> numbers = new ArrayList<>();

            String line;
            while (!(line = reader.readLine()).isEmpty()) {
                String[] split = line.split("-");
                result.add(List.of(Long.parseLong(split[0]), Long.parseLong(split[1])));
            }

            while ((line = reader.readLine()) != null) {
                numbers.add(Long.parseLong(line));
            }
            System.out.println();

            for (Long n : numbers) {
                for (List<Long> pair : result) {
                    if (n >= pair.getFirst() && n <= pair.get(1)) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    @Override
    public long calculatePartTwo() throws IOException {
        long res = 0;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day5.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            MultiRange<Long> mr = new MultiRange<>();

            String line;
            while (!(line = reader.readLine()).isEmpty()) {
                String[] split = line.split("-");
                Range<Long> range = Range.of(Long.parseLong(split[0]), Long.parseLong(split[1]));
                range.setEndIncluded(true);
                mr.add(range);
            }

            while (!mr.isEmpty()) {
                var r = mr.next();
                res += r.getEnd() - r.getStart() + 1;
            }

        }
        return res;
    }



}
