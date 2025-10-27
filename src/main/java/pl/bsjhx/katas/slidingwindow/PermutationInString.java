package pl.bsjhx.katas.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int l = 0;
        int r = s1.length();

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1s = new int[26];
        int[] cs = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1s[s1.charAt(i) - 97]++;
            cs[s2.charAt(i) - 97]++;
        }

        while (r <= s2.length()) {
            if (Arrays.equals(s1s, cs)) {
                return true;
            }

            cs[s2.charAt(l) - 97]--;
            if (r == s2.length()) {
                return false;
            }
            cs[s2.charAt(r) - 97]++;

            l++;
            r++;
        }

        return false;
    }

    public boolean checkInclusionSimple(String s1, String s2) {
        int l = 0;
        int r = s1.length();

        if (s1.length() > s2.length()) {
            return false;
        }

        var sorted1 = Arrays.stream(s1.split("")).sorted().collect(Collectors.joining());

        while (r <= s2.length()) {
            var substring = Arrays.stream(s2.substring(l, r).split("")).sorted().collect(Collectors.joining());
            if (substring.equals(sorted1)) {
                return true;
            }
            r++;
            l++;

        }

        return false;
    }
}
