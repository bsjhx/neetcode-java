package pl.bsjhx.backtracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class CombinationSum {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Stack<Integer> currSet = new Stack<>();
        helper(0, candidates, target, currSet, 0);
        return result;
    }

    private void helper(int i, int[] candidates, int target, Stack<Integer> currSet, int currSum) {
        if (currSum == target) {
            result.add(new LinkedList<>(currSet));
            return;
        }
        if (i == candidates.length) {
            return;
        }
        if (currSum + candidates[i] > target) {
            return;
        }

        currSet.push(candidates[i]);
        helper(i, candidates, target, currSet, currSum + candidates[i]);
        currSet.pop();
        helper(i + 1, candidates, target, currSet, currSum);
    }
}