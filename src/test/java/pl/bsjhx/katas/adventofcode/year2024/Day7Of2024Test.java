package pl.bsjhx.katas.adventofcode.year2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day7Of2024Test {

    @Test
    void calculatePartOne() throws IOException {
        var day = new Day7Of2024();
        assertEquals(3749, day.calculatePartOne());
    }
}