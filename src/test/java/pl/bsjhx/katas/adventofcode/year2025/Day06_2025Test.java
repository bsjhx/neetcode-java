package pl.bsjhx.katas.adventofcode.year2025;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class Day06_2025Test {

    @Test
    void name() throws IOException {
        var sol = new Day06_2025();
//        assertEquals(4277556L, sol.calculatePartOne());
        assertEquals(3263827L, sol.calculatePartTwo());

    }
}