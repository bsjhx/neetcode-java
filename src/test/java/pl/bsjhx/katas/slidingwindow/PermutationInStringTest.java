package pl.bsjhx.katas.slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationInStringTest {

    @Test
    void checkInclusion() {
        var solution = new PermutationInString();
//        assertFalse(solution.checkInclusion("qwerty", "q"));
        assertTrue(solution.checkInclusion("adc", "dcda"));
        assertTrue(solution.checkInclusion("abc", "dasdacvdfcabgfghnfg"));
        assertFalse(solution.checkInclusion("abc", "lecaabee"));

        assertFalse(solution.checkInclusionSimple("qwerty", "q"));
        assertTrue(solution.checkInclusionSimple("abc", "dasdacvdfcabgfghnfg"));
        assertTrue(solution.checkInclusionSimple("adc", "dcda"));
        assertFalse(solution.checkInclusionSimple("abc", "lecaabee"));
    }
}