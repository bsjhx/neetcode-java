package pl.bsjhx.katas;

import java.util.Stack;

public class Task {
    // }}}}
    public boolean isValid(String input) {
        Stack<Character> s = new Stack<>();
        char[] chars = input.toCharArray();
        for (char i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                s.push(currentChar);
            } else {
                var lastCStack = s.peek();
                if (lastCStack == '(' && currentChar == ')' || lastCStack == '{' && currentChar == '}') {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}
