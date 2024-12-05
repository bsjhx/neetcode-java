package pl.bsjhx.katas.adventofcode.year2024;


import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class Day3Of2024 implements Advent {

    public long calculatePartOne() throws IOException {
        var data = readFromFile();
        var left = 0;
        var right = 3;
        var result = 0L;
        var mode = "first";
        var current = "";
        var first = 0L;
        var second = 0L;
        var lastMul = 0;

        while (right < data.length()) {
            switch (mode) {
                case "first":
                    current = data.substring(left, right + 1);
                    if ("mul(".equals(current)) {
                        lastMul = right;
                        left = right + 1;
                        right++;
                        mode = "mul_found";
                    } else {
                        left++;
                        right++;
                    }
                    break;
                case "mul_found": {
                    current = data.substring(left, right + 1);
                    if (isNumeric(current)) {
                        right++;
                    } else if (current.endsWith(",")) {
                        first = Integer.parseInt(data.substring(left, right));
                        mode = "first_number_found";
                        left = right + 1;
                        right++;
                    } else {
                        mode = "first";
                        left = lastMul + 1;
                        right = lastMul + 4;
                    }
                    break;
                }
                case "first_number_found": {
                    current = data.substring(left, right + 1);
                    if (isNumeric(current)) {
                        right++;
                    } else if (current.endsWith(")")) {
                        second = Integer.parseInt(data.substring(left, right));
                        mode = "first";
                        left = right + 1;
                        right += 4;
                        result += (first * second);
                    } else {
                        mode = "first";
                        left = lastMul + 1;
                        right = lastMul + 4;
                    }
                    break;
                }
                default: throw new IllegalStateException();
            }
        }

        return result;
    }

    private String readFromFile() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try {
            URL resource = Objects.requireNonNull(classloader.getResource("adventofcode2024/day3.txt"));
            return new Scanner(new File(resource.toURI())).useDelimiter("\\Z").next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
