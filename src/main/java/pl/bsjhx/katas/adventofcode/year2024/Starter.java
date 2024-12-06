package pl.bsjhx.katas.adventofcode.year2024;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Starter {

    public static void main(String[] args) throws IOException {
        List<Advent> days = new ArrayList<>(24);
        days.add(new Day1Of2024());
        days.add(new Day2Of2024());
        days.add(new Day3Of2024());
        days.add(new Day4Of2024());

        for (int i = 0; i < days.size(); i++) {
            System.out.printf("Day %s, part 1 result: %s%n", i + 1, days.get(i).calculatePartOne());
            System.out.printf("Day %s, part 2 result: %s%n", i + 1, days.get(i).calculatePartTwo());
        }
    }
}
