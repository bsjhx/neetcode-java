package pl.bsjhx.katas.backtracking;

import java.util.*;

class Subsets {

    List<List<Integer>> subsets = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        Stack<Integer> curr = new Stack<>();
        subsets(0, nums, curr);

        return subsets;
    }

    private void subsets(int i, int[] nums, Stack<Integer> curr) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<>(curr));
            return;
        }
        
        curr.push(nums[i]);
        subsets(i + 1, nums, curr);

        curr.pop();
        subsets(i + 1, nums, curr);
    }
}