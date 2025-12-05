package pl.bsjhx.katas.adventofcode.year2025;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day05_2025Test {

    @Test
    void name() throws IOException {
        var sol = new Day05_2025();
        assertEquals(3L, sol.calculatePartOne());
    }

}