package pl.bsjhx.katas.adventofcode.year2025;

import pl.bsjhx.katas.adventofcode.Advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Day03_2025 implements Advent {

    @Override
    public long calculatePartOne() throws IOException {
        long res = 0L;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        int o = 0;

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
                o++;
            }

        }
        return res;
    }

    @Override
    public long calculatePartTwo() throws IOException {
        return Advent.super.calculatePartTwo();
    }
}
