package pl.bsjhx.katas.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        Stack<String> stack = new Stack<>();
        List<String> res = new ArrayList<>();

        helper(n, 0, 0, res, stack);

        return res;
    }

    private void helper(int n, int open, int close, List<String> res, Stack<String> curr) {
        if (open == n && close == n) {
            res.add(curr.stream().collect(Collectors.joining("")));
            return;
        }
        
        if (open < n) {
            curr.push("(");
            helper(n, open + 1, close, res, curr);
            curr.pop();
        }
        
        if (close < open) {
            curr.push(")");
            helper(n, open, close + 1, res, curr);
            curr.pop();
        }
    }
}
