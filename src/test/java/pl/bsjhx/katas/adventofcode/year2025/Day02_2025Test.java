package pl.bsjhx.katas.adventofcode.year2025;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Day02_2025Test {

    @Test
    void name() throws IOException {
        var sol = new Day02_2025();
        assertEquals(1227775554L, sol.calculatePartOne());
    }
}