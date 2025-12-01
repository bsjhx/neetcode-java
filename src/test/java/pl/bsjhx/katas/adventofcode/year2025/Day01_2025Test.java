package pl.bsjhx.katas.adventofcode.year2025;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day01_2025Test {

    @Test
    void calculatePartOne() throws IOException {
        var sol = new Day01_2025();
//        assertEquals(3L, sol.calculatePartOne());
        assertEquals(6L, sol.calculatePartTwo());
    }
}