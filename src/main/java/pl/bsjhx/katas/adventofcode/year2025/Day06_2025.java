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
                for (List<Long> longs : result) {
                    if ("+".equals(op)) {
                        temp += longs.get(i);
                    } else {
                        if (temp == 0L) temp = 1L;
                        temp *= longs.get(i);
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
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day6.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            List<String> operations = new ArrayList<>();

            String[][] ss = new String[4][4000];
            for (String[] strings : ss) {
                Arrays.fill(strings, "");
            }

            String line;
            int ii = 0;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("+") || line.startsWith("*")) {
                    String[] split = line.split(" ");
                    operations = Arrays.stream(split)
                            .filter(s -> !s.isEmpty()).toList();
                } else {
                    var t = line.split("");
                    System.arraycopy(t, 0, ss[ii], 0, t.length);
                    ii++;
                }
            }

            var t = 0L;
            ii = 0;
            int opC = 0;

            for (int i = 0; i < ss[0].length; i++) {
                var numberS = new StringBuilder();

                for (String[] s : ss) {
                    var potentialNumber = s[i];
                    if (!potentialNumber.isEmpty() && !potentialNumber.equals(" ")) {
                        numberS.append(potentialNumber);
                    }

                    if (!" ".equals(potentialNumber)) {
                    }
                }

                if (!numberS.isEmpty()) {
                    var a = Long.parseLong(numberS.toString());
                    if ("*".equals(operations.get(opC))) {
                        if (0L == t) t = 1L;
                        t *= a;
                    } else {
                        t += a;
                    }
                    ii++;
                } else {
                    res += t;
                    t = 0L;
                    ii = 0;
                    opC++;
                }
            }
        }
        return res;
    }

}
