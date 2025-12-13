package pl.bsjhx.katas.adventofcode.year2025;

import pl.bsjhx.katas.adventofcode.Advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Day07_2025 implements Advent {

    @Override
    public long calculatePartOne() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day7.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            int[] beamPositions = new int[141];
            for (int i = 0; i < 141; i++) {
                beamPositions[i] = -1;
            }

            var counter = 0;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("");
                for (int i = 0; i < split.length; i++) {
                    var s = split[i];
                    if ("S".equals(s)) {
                        beamPositions[i] = 1;
                        break;
                    }
                    if ("^".equals(split[i]) && beamPositions[i] == 1) {
                        beamPositions[i] = -1;
                        beamPositions[i - 1] = 1;
                        beamPositions[i + 1] = 1;
                        counter++;
                    }
                }
            }

            return counter;
        }
    }

    @Override
    public long calculatePartTwo() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day7.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            int[][] beamPositions = new int[71][140];
            for (int i = 0; i < 71; i++) {
                for (int j = 0; j < 140; j++) {
                    beamPositions[i][j] = 0;
                }
            }

            int row = 0;
            int start = -1;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split("");
                if (Arrays.stream(split).filter(s -> !".".equals(s)).count() == 0 || line.contains("S")) {
                    continue;
                }
                for (int i = 0; i < split.length; i++) {
                    var s = split[i];
                    if ("^".equals(s)) {
                        if (start == -1) start = i;
                        beamPositions[row][i] = 1;
                    }
                }
                row++;
            }

            long[][] memory = new long[row + 1][142];
            for (int i = 0; i < memory.length; i++) {
                Arrays.fill(memory[i], -1);
            }

            return dfs(beamPositions, row, 0, start, memory);
        }
    }

    private long dfs(int[][] beamPositions, int lastRow, int row, int pos, long[][] memory) {
        System.out.println("POS " + row + " " + pos);
        long counter = 0;

        if (memory[row][pos] != -1) {
            return memory[row][pos];
        }

        if (row == lastRow) {
            counter++;
            memory[row][pos] = counter;
            return counter;
        }

        if (beamPositions[row][pos] == 1) {
            int left = pos - 1;
            int right = pos + 1;
            counter += dfs(beamPositions, lastRow, row + 1, left, memory);
            counter += dfs(beamPositions, lastRow, row + 1, right, memory);
        } else {
            counter += dfs(beamPositions, lastRow, row + 1, pos, memory);
        }
        memory[row][pos] = counter;
        return counter;
    }
}
