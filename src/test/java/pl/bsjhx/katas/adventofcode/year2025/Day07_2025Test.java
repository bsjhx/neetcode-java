package pl.bsjhx.katas.adventofcode.year2025;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day07_2025Test {

    @Test
    void name() throws IOException {
        assertEquals(21L, new Day07_2025().calculatePartOne());
        assertEquals(40L, new Day07_2025().calculatePartTwo());
    }
}