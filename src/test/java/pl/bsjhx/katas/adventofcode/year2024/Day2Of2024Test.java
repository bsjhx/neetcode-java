package pl.bsjhx.katas.adventofcode.year2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day2Of2024Test {

    @Test
    void calculate() throws IOException {
        var day = new Day2Of2024();
        assertEquals(2, day.calculate());
    }
}