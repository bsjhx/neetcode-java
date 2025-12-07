package pl.bsjhx.katas.adventofcode.year2025;

import pl.bsjhx.katas.adventofcode.Advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Array;
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
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day6.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            List<List<String>> numbersLines = new ArrayList<>();
            List<String> operations = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                List<String> tempResult = new ArrayList<>();
                if (line.startsWith("*") || line.startsWith("+ ")) {
                    String[] split = line.split(" ");
                    operations = Arrays.stream(split)
                            .filter(s -> !s.isEmpty())
                            .toList();
                } else {
                    String[] split = line.split("");
                    StringBuilder temp = new StringBuilder();
                    boolean isBegin = true;
                    for (int i = 0; i < split.length; i++) {
                        String s = split[i];
                        if (isNumber(s)) {
                            isBegin = false;
                            temp.append(s);
                        } else {
                            while (i < split.length && " ".equals(split[i])) {
                                i++;
                                temp.append(s);
                            }
                            i--;
                            if (!isBegin) {
                                tempResult.add(temp.toString());
                                temp = new StringBuilder();
                            } else {
                                isBegin = false;
                            }
                        }
                    }
                    if (!tempResult.contains(temp.toString()) && !temp.isEmpty()) {
                        tempResult.add(temp.toString());
                    }
                }
                if (!tempResult.isEmpty())
                    numbersLines.add(tempResult);
            }

            for (int i = 0; i < numbersLines.getFirst().size(); i++) {
                String op = operations.get(i);
                long temp = 0;
                List<StringBuilder> nums = new ArrayList<>();
                int max = 0;
                for (int j = 0; j < numbersLines.size(); j++) {
                    String curr = numbersLines.get(j).get(i);
                    String[] splitted = curr.split("");
                    if (splitted.length > max) {
                        for (int k = 0; k < splitted.length - max; k++) {
                            nums.add(new StringBuilder());
                        }
                        max = splitted.length;
                    }
                    int lastSplitted = splitted.length - 1;
                    int lastNum = nums.size() - 1;
                    while (lastSplitted >= 0) {
                        nums.get(lastNum).append(splitted[lastSplitted]);
                        lastNum--;
                        lastSplitted--;
                    }
                    System.out.println();
                }
                res += temp;
            }

        }
        return res;
    }

    private boolean isNumber(String s) {
        return List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
                .stream()
                .filter(s::equals)
                .count() > 0;
    }
}
