package pl.bsjhx.katas.adventofcode.year2025;

import pl.bsjhx.katas.adventofcode.Advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
        return Advent.super.calculatePartTwo();
    }
}
