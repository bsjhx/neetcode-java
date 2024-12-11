package pl.bsjhx.katas.adventofcode.year2024;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Day11Of2024 implements Advent {

    public long calculatePartOne() throws IOException {
        var data = readFromFile();

        Stack<String> stack = new Stack<>();
        data.forEach(stack::push);
        
        var i = 0;
   
        while (i < 25) {
            i++;
            List<String> temp = new ArrayList<>(stack.size());
            while (!stack.isEmpty()) {
                var curr = stack.pop();

                if ("0".equals(curr)) {
                    temp.add("1");
                } else if (curr.length() % 2 == 0) {
                    temp.add(String.valueOf(Long.parseLong(curr.substring(0, curr.length() / 2))));                    
                    temp.add(String.valueOf(Long.parseLong(curr.substring(curr.length() / 2))));                    
                } else {
                    temp.add(String.valueOf(Long.parseLong(curr) * 2024));
                }
            }

            temp.forEach(stack::push);
        }

        return stack.size();
    }

    public long calculatePartTwo() throws IOException {
        return 0;
    }

    private List<String> readFromFile() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2024/day11.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            List<List<String>> result = new ArrayList<>();

            String line = reader.readLine();
            return Arrays.stream(line.split(" ")).toList();
        }
    }

}
