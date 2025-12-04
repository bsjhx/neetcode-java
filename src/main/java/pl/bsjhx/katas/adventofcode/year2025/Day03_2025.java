package pl.bsjhx.katas.adventofcode.year2025;

import pl.bsjhx.katas.adventofcode.Advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Day03_2025 implements Advent {

    @Override
    public long calculatePartOne() throws IOException {
        long res = 0L;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day3.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            while ((line = reader.readLine()) != null) {
                int l = 0;
                int r = 1;
                int maxL = -1;
                int maxR = -1;
                String[] split = line.split("");
                var val = 10L * Integer.parseInt(split[l]) + Integer.parseInt(split[r]);

                for (int i = 1; i < split.length; i++) {
                    int n = Integer.parseInt(split[i]);
                    int nl = Integer.parseInt(split[l]);
                    int nr = Integer.parseInt(split[r]);

                    maxL = Math.max(maxL, nl);
                    maxR = Math.max(maxR, nr);

                    if (n > nl && i != split.length - 1) {
                        l = i;
                        r = i + 1;
                    } else if (n > nr) {
                        r = i;
                    }
                    val = 10L * Integer.parseInt(split[l]) + Integer.parseInt(split[r]);
                    if (val == 99L) {
                        break;
                    }
                }

                res += val;
            }

        }
        return res;
    }

    @Override
    public long calculatePartTwo() throws IOException {
        long res = 0L;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        PriorityQueue<Integer> pq = new PriorityQueue<>(12);

        try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day3.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("");

                for (String s : split) {
                    int n = Integer.parseInt(s);
                    if (pq.size() < 12) {
                        pq.add(n);
                    } else {
                        if (n > pq.peek()) {
                            pq.poll();
                            pq.add(n);
                        }
                    }
                }
                StringBuilder val = new StringBuilder();

                while (!pq.isEmpty()) {
                    val.append(pq.poll().toString());
                }

                pq.clear();

                String string = val.reverse().toString();
                res += Long.parseLong(string);
            }

        }
        return res;
    }
}
