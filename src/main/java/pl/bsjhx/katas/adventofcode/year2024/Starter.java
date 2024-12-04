package pl.bsjhx.katas.adventofcode.year2024;

import java.io.IOException;

public class Starter {

    public static void main(String[] args) throws IOException {
        var day1 = new Day1Of2024();
        System.out.printf("Day 1, part 1 result %s%n", day1.calculate());
        System.out.printf("Day 1, part 2 result %s%n", day1.calculate2());
        
        var day2 = new Day2Of2024();
        System.out.printf("Day 2, part 1 result %s%n", day2.calculate());
//        System.out.printf("Day 2, part 2 result %s%n", day2.calculate2());
        
        
    }
}
