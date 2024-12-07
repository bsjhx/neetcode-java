package pl.bsjhx.katas.adventofcode.year2024;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Day5Of2024 implements Advent {

    public long calculatePartOne() throws IOException {
        var fromFile = readFromFile();
        var rules = fromFile.orderRules;
        
        return fromFile.paths.stream().mapToInt(path -> {
            List<String> previous = new ArrayList<>();
            for (var p : path) {
                if (previous.isEmpty()) {
                    previous.add(p);
                    continue;
                }
                
                for (var pr : previous) {
                    if (!rules.containsKey(pr) || !rules.get(pr).contains(p)) {
                        return 0;
                    }
                }
                previous.add(p);
            }

            var middle = path.get(path.size() / 2);
            return Integer.parseInt(middle);
        }).sum();
    }
    
    public long calculatePartTwo() throws IOException {
        var fromFile = readFromFile();
        var rules = fromFile.orderRules;

        return fromFile.paths.stream().mapToInt(path -> {
            List<String> previous = new ArrayList<>();
            var isValid = true;

            for (int j = 0; j < path.size(); j++) {
                var p = path.get(j);
                if (!rules.containsKey(p) && j != path.size() - 1) {
                    previous.add(p);
                    isValid = false;
                    continue;
                }
                if (previous.isEmpty()) {
                    previous.add(p);
                    continue;
                }

                var prevSize = previous.size();
                for (int i = 0; i < prevSize; i++) {
                    if (!rules.containsKey(previous.get(i))) {
                        previous.add(i, p);
                    } else if (!rules.get(previous.get(i)).contains(p) ){
                        isValid = false;
                        previous.add(i, p);
                    } else {
                        previous.add(p);
                    }
                }
            }

            System.out.print(isValid);
            System.out.print("    ");
            System.out.println(path);
            var middle = previous.get(path.size() / 2);
            return isValid ? 0 : Integer.parseInt(middle);
        }).sum();
    }

    private FromFile readFromFile() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2024/day5.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            Map<String, List<String>> orderRules = new HashMap<>();
            String line;
            while (!Objects.equals(line = reader.readLine(), "")) {
                String[] parts = line.split("\\|");
                orderRules.computeIfAbsent(parts[0], k -> new ArrayList<>()).add(parts[1]);
            }

            List<List<String>> paths = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                paths.add(Arrays.stream(parts).toList());
            }            

            return new FromFile(orderRules, paths);
        }
    }
    
    record FromFile(Map<String, List<String>> orderRules, List<List<String>> paths) {}
}
