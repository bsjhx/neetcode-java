package pl.bsjhx.katas.adventofcode.year2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day5Of2024Test {

    @Test
    void calculatePartOne() throws IOException {
        var day = new Day5Of2024();
        assertEquals(143, day.calculatePartOne());
    }
}