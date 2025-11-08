package pl.bsjhx.katas.neetcode.arraysandhashing;

import java.util.Arrays;
import java.util.List;

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        int max = 0;
        int currentMax = -1;
        int prev = 0;

        List<Integer> a = Arrays.stream(nums).distinct().sorted().boxed().toList();
        Arrays.sort(nums);

        for (var n : a) {
            if (currentMax == -1) {
                currentMax = 1;
            } else {
                if (n - prev == 1) {
                    currentMax++;
                } else {
                    if (currentMax > max) {
                        max = currentMax;
                    }
                    currentMax = 1;
                }
            }
            prev = n;
        }
        return Math.max(max, currentMax);
    }
}
