package pl.bsjhx.katas.neetcode.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrappingWaterTest {

    @Test
    void trap() {
        var solution = new TrappingWater();
        assertEquals(26, solution.trap(new int[]{0, 1, 2, 0, 3, 0, 1, 2, 0, 0, 4, 2, 1, 2, 5, 0, 1, 2, 0, 2}));
//        assertEquals(0, solution.trap(new int[]{0}));
//        assertEquals(1, solution.trap(new int[]{4, 2, 3}));
//        assertEquals(9, solution.trap(new int[]{0, 2, 0, 3, 1, 0, 1, 3, 2, 1}));
//        assertEquals(10, solution.trap(new int[]{0, 0, 2, 0, 0, 2, 2, 0, 0, 0, 2, 0}));
//        assertEquals(8, solution.trap(new int[]{0, 0, 2, 1, 1, 2, 2, 0, 0, 0, 2, 0}));
//        assertEquals(6, solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
//        assertEquals(3, solution.trap(new int[]{4, 3, 2, 3, 2, 0, 2}));
//        assertEquals(0, solution.trap(new int[]{0}));
    }
}