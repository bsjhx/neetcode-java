package pl.bsjhx.katas.adventofcode.year2025;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day03_2025Test {

    @Test
    void name() throws IOException {
        var sol = new Day03_2025();
        assertEquals(357L, sol.calculatePartOne());
        assertEquals(3121910778619L, sol.calculatePartTwo());
    }
}