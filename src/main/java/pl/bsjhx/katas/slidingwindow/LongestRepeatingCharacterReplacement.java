package pl.bsjhx.katas.slidingwindow;

import java.util.*;
import java.util.stream.Collectors;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        if (s.length() <= k) {
            return s.length();
        }

        int l = 0;
        int r = 1;
        int max = 0;
        var aaa = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        while (r <= s.length()) {
            var slice = Arrays.stream(s.substring(l, r).split("")).toList();

            long max2 = -1;
            for (String c : slice) {
                var curr = slice.stream().filter(cc -> cc.equals(c)).count();
                if (max2 < curr) {
                    max2 = curr;
                }
            }

            long ff = slice.size() - max2;
            if (ff > k) {
                l++;
            } else {
                r++;
                max = Math.max(max, slice.size());
            }

        }

        return max;
    }
}
