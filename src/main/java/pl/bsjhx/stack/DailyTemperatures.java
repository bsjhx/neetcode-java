package pl.bsjhx.stack;

import java.util.Stack;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                Integer peeked = stack.peek();
                while (temperatures[peeked] < temperatures[i]) {
                    stack.pop();
                    result[peeked] = i - peeked;
                    if (stack.isEmpty())
                        break;
                    peeked = stack.peek();
                }
                    stack.push(i);
            }
        }

        return result;
    }
}