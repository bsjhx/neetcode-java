package pl.bsjhx.slidingwindow;

import java.util.HashSet;
import java.util.Set;

class LongestSubset {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        char[] chars = s.toCharArray();
        int l = 0, r = 0;
        int res = 1;

        while (r < s.length()) {
            char c = chars[r];
            if (s.substring(l, r).indexOf(c) == -1) {
                r++;
                res = Math.max(r - l, res);
            } else {
                l++;
                while (s.substring(l, r).indexOf(chars[r]) > -1 && l < r) {
                    l++;
                }
            }
        }

        return res;
    }
}