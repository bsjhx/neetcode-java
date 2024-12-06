package pl.bsjhx.katas.adventofcode.year2024;


import java.io.*;
import java.util.*;

public class Day4Of2024 implements Advent {

    public long calculatePartOne() throws IOException {
        var data = readFromFile();
        var result = 0;
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.getFirst().size(); j++) {
                if ("X".equals(data.get(i).get(j))) {
                    result += helper(data, "X", i, j, 1, 0);
                    result += helper(data, "X", i, j, 0, 1);
                    result += helper(data, "X", i, j, -1, 0);
                    result += helper(data, "X", i, j, 0, -1);
                    result += helper(data, "X", i, j, 1, -1);
                    result += helper(data, "X", i, j, -1, -1);
                    result += helper(data, "X", i, j, 1, 1);
                    result += helper(data, "X", i, j, -1, 1);
                }
            }
        }
        return result;
    }
    
    public long calculatePartTwo() throws IOException {
        var data = readFromFile();
        var result = 0;
        for (int i = 1; i < data.size() - 1; i++) {
            for (int j = 1; j < data.getFirst().size() - 1; j++) {
                if ("A".equals(data.get(i).get(j))) {
                    String diagonalOne = getDiagonalOne(data, i, j);
                    String diagonalTwo = getDiagonalTwo(data, i, j);
                    if (diagonalOne.equals("MAS") || diagonalOne.equals("SAM")) {
                        if (diagonalTwo.equals("MAS") || diagonalTwo.equals("SAM")) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    private static String getDiagonalOne(List<List<String>> data, int i, int j) {
        return data.get(i - 1).get(j - 1) + data.get(i).get(j) + data.get(i + 1).get(j + 1);
    }
    
    private static String getDiagonalTwo(List<List<String>> data, int i, int j) {
        return data.get(i - 1).get(j + 1) + data.get(i).get(j) + data.get(i + 1).get(j - 1);
    }

    private final Map<String, String> xms = Map.of(
            "X", "M",
            "M", "A",
            "A", "S",
            "S", "END"
    );

    private int helper(final List<List<String>> data, String el, int i, int j, final int dirI, final int dirJ) {
        if ("S".equals(el)) {
            return 1;
        }

        int newJ = j + dirJ;
        int newI = i + dirI;
        if (newI >= 0 && newJ >= 0 &&
                newI < data.size()
                && newJ < data.getFirst().size()
                && Objects.equals(xms.get(el), data.get(newI).get(newJ))
        ) {
            return helper(data, data.get(newI).get(newJ), newI, newJ, dirI, dirJ);
        }

        return 0;
    }

    private List<List<String>> readFromFile() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2024/day4.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            List<List<String>> result = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("");
                result.add(Arrays.stream(parts).toList());
            }

            return result;
        }
    }
}
