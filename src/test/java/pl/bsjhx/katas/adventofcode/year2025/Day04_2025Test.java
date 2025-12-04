package pl.bsjhx.katas.adventofcode.year2025;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day04_2025Test {

    @Test
    void name() throws IOException {
        var sol = new Day04_2025();
        assertEquals(13L, sol.calculatePartOne());
        assertEquals(43L, sol.calculatePartTwo());
    }
}