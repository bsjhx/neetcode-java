package pl.bsjhx.katas.adventofcode.year2025;

import pl.bsjhx.katas.adventofcode.Advent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Day08_2025 implements Advent {

    @Override
    public long calculatePartOne() throws IOException {
        long res = 0;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("adventofcode2025/day8.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            List<List<Long>> map = new ArrayList<>();
            PriorityQueue<List<List<Long>>> queue = new PriorityQueue<>(getListComparator());

            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(",");
                map.add(List.of(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2])));
            }

            for (int i = 0; i < map.size(); i++) {
                for (int j = i + 1; j < map.size(); j++) {
                    List<List<Long>> path = List.of(map.get(i), map.get(j));
                    if (queue.size() < 10) {
                        queue.add(path);
                    } else {
                        if (distance(queue.peek().getFirst(), queue.peek().getLast()) > distance(path.getFirst(), path.getLast())) {
                            queue.poll();
                            queue.add(path);
                        }
                    }
                }
            }

            List<Set<List<Long>>> mapped = new ArrayList<>();
            while (!queue.isEmpty()) {
//                System.out.println("-------------------");
//                System.out.println("-------------------");
//                System.out.println("Step: " + (10 - queue.size()));
                List<List<Long>> path = queue.poll();
//                System.out.println("\tPath to add:" + path);
//                for (var l : mapped) {
//                    System.out.println("\tMapped circuit: " + l);
//                }
                boolean f = false;
                Set<List<Long>> found = null;

                for (var circuit : mapped) {
                    if (circuit.contains(path.getFirst()) && circuit.contains(path.getLast())) {
                        f = true;
                        break;
                    }
                    if (circuit.contains(path.getFirst()) || circuit.contains(path.getLast())) {
                        f = true;
                        found = circuit;
                        break;
                    }
                }

                if (f && found != null) {
                    found.add(path.getFirst());
                    found.add(path.getLast());
                } else if (!f) {
                    mapped.add(new HashSet<>(path));
                }
            }

            return mapped.stream()
                            .map(Set::size)
                                    .sorted(Comparator.reverseOrder())
                    .limit(3)
                                            .mapToLong(Long::valueOf)
                                                    .reduce(1, (a, b) -> a * b);

        }
//        return res;
    }

    private static Comparator<List<List<Long>>> getListComparator() {
        return (a, b) -> {
            var disA = distance(a.getFirst(), a.getLast());
            var disB = distance(b.getFirst(), b.getLast());
            return Double.compare(disB, disA);
        };
    }

    private static double distance(List<Long> pointA, List<Long> pointB) {
        return Math.sqrt(
                Math.pow(pointA.getFirst() - pointB.getFirst(), 2) +
                        Math.pow(pointA.get(1) - pointB.get(1), 2) +
                        Math.pow(pointA.getLast() - pointB.getLast(), 2)
        );
    }

    @Override
    public long calculatePartTwo() throws IOException {
        return Advent.super.calculatePartOne();
    }
}

