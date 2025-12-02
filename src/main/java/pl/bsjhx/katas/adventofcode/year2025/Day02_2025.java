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

public class Day02_2025 implements Advent {

    @Override
    public long calculatePartOne() throws IOException {
        long res = 0L;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day2.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] pairs = line.split(",");

                for (String pair : pairs) {
                    String[] splitted = pair.split("-");
                    long start = Long.parseLong(splitted[0]);
                    long end = Long.parseLong(splitted[1]);
                    for (long i = start; i <= end; i++) {
                        String v = String.valueOf(i);
                        if (v.length() % 2 == 0) {
                            var l = v.substring(0, v.length() / 2);
                            var r = v.substring(v.length() / 2);
                            if (l.equals(r)) {
                                res += i;
                            }
                        }
                    }
                }
            }

        }
        return res;
    }

    @Override
    public long calculatePartTwo() throws IOException {
        return 0;
    }

}
