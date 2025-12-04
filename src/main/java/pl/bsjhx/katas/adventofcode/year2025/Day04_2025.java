package pl.bsjhx.katas.adventofcode.year2025;

import pl.bsjhx.katas.adventofcode.Advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day04_2025 implements Advent {

    @Override
    public long calculatePartOne() throws IOException {
        List<List<String>> map = readFromFile();
        long res = 0;

        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.get(i).size(); j++) {
                if ("@".equals(map.get(i).get(j))) {
                    int c = 0;
                    for (List<Integer> dir : DIRECTIONS_8) {
                        if (Advent.isInMap(i + dir.get(0), j + dir.get(1), map)) {
                            String val = map.get(i + dir.get(0)).get(j + dir.get(1));
                            if ("@".equals(val)) {
                                c++;
                            }
                        }
                    }
                    if (c < 4) {
                        res++;
                    }

                }
            }
        }

        return res;
    }

    @Override
    public long calculatePartTwo() throws IOException {
        List<List<String>> map = readFromFile();
        long res = 0;
        boolean found = true;

        while (found) {
            found = false;
            for (int i = 0; i < map.size(); i++) {
                for (int j = 0; j < map.get(i).size(); j++) {
                    if ("@".equals(map.get(i).get(j))) {
                        int c = 0;
                        for (List<Integer> dir : DIRECTIONS_8) {
                            if (Advent.isInMap(i + dir.get(0), j + dir.get(1), map)) {
                                String val = map.get(i + dir.get(0)).get(j + dir.get(1));
                                if ("@".equals(val)) {
                                    c++;
                                }
                            }
                        }
                        if (c < 4) {
                            res++;
                            found = true;
                            map.get(i).set(j, ".");
                        }

                    }
                }
            }
        }

        return res;
    }

    private List<List<String>> readFromFile() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day4.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            List<List<String>> result = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("");
                result.add(new ArrayList<>(Arrays.stream(parts).toList()));
            }

            return result;
        }
    }
}
