package pl.bsjhx.katas.adventofcode.year2024;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day1Of2024Test {

    @Test
    void calculate() throws IOException {
        var day1 = new Day1Of2024();
        assertEquals(11, day1.calculate());
    }
    
    @Test
    void calculate2() throws IOException {
        var day1 = new Day1Of2024();
        assertEquals(31, day1.calculate2());
    }
}