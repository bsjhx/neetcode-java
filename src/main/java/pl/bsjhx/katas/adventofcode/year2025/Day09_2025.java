package pl.bsjhx.katas.adventofcode.year2025;

import pl.bsjhx.katas.adventofcode.Advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Day09_2025 implements Advent {

        @Override
        public long calculatePartOne() throws IOException {
             ClassLoader classloader = Thread.currentThread().getContextClassLoader();
             try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day9.txt");
                  BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

                 String line;
                 while ((line = reader.readLine()) != null) {
                 }

                 return 0L;
             }
        }

        @Override
        public long calculatePartTwo() throws IOException {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
                         try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day9.txt");
                              BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

                             String line;
                             while ((line = reader.readLine()) != null) {
                             }

                             return 0L;
                }
        }
}
