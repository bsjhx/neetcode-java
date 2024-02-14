package pl.bsjhx.slidingwindow;

import org.junit.jupiter.api.Test;
import pl.bsjhx.slidingwindow.LongestSubset;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubsetTest {

    @Test
    void lengthOfLongestSubstring() {
        LongestSubset subset = new LongestSubset();
        // assertEquals(0, subset.lengthOfLongestSubstring(""));
        // assertEquals(1, subset.lengthOfLongestSubstring("a"));
        // assertEquals(2, subset.lengthOfLongestSubstring("ab"));
        // assertEquals(3, subset.lengthOfLongestSubstring("abcabcbb"));
        // assertEquals(3, subset.lengthOfLongestSubstring("pwwkew"));
        assertEquals(3, subset.lengthOfLongestSubstring("dvdf"));
    }
}