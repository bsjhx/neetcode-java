package pl.bsjhx.katas.adventofcode.year2025;

import pl.bsjhx.katas.adventofcode.Advent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Starter {

    public static void main(String[] args) throws IOException {
        List<Advent> days = new ArrayList<>(24);
        days.add(new Day01_2025());
        days.add(new Day02_2025());
        days.add(new Day03_2025());
        days.add(new Day04_2025());
        days.add(new Day05_2025());
        days.add(new Day06_2025());
        days.add(new Day07_2025());

        for (int i = 0; i < days.size(); i++) {
            System.out.printf("Day %s, part 1 result: %s%n", i + 1, days.get(i).calculatePartOne());
            System.out.printf("Day %s, part 2 result: %s%n", i + 1, days.get(i).calculatePartTwo());
        }
    }
}
