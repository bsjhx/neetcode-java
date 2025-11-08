package pl.bsjhx.katas.neetcode.slidingwindow;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.slidingwindow.LongestRepeatingCharacterReplacement;

import static org.junit.jupiter.api.Assertions.*;

class LongestRepeatingCharacterReplacementTest {

    @Test
    void characterReplacement() {
        var solution = new LongestRepeatingCharacterReplacement();
        assertEquals(5, solution.characterReplacement("AAABABB", 1));
        assertEquals(4, solution.characterReplacement("ABBA", 2));
    }
}