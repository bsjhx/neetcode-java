package pl.bsjhx.katas.adventofcode.year2025;

import pl.bsjhx.katas.adventofcode.Advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day06_2025 implements Advent {

    @Override
    public long calculatePartOne() throws IOException {
        long res = 0;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day6.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            List<List<Long>> result = new ArrayList<>();
            List<String> operations = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("*") || line.startsWith("+ ")) {
                    String[] split = line.split(" ");
                    operations = Arrays.stream(split)
                            .filter(s -> !s.isEmpty()).toList();
                } else {
                    String[] split = line.split(" ");
                    result.add(Arrays.stream(split)
                            .filter(s -> !s.isEmpty())
                            .map(Long::parseLong)
                            .toList());
                }
            }

            for (int i = 0; i < result.getFirst().size(); i++) {
                String op = operations.get(i);
                long temp = 0;
                for (int j = 0; j < result.size(); j++) {
                    if ("+".equals(op)) {
                        temp += result.get(j).get(i);
                    } else {
                        if (temp == 0L) temp = 1L;
                        temp *= result.get(j).get(i);
                    }
                }
                res += temp;
            }

        }
        return res;
    }

    @Override
    public long calculatePartTwo() throws IOException {
        long res = 0;
        return res;
    }
}
