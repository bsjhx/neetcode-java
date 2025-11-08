package pl.bsjhx.katas.neetcode.stack;

class MinStack {

    private int[] stack;

    private int lastElement = -1;

    private int[] minStack;

    private int minLastElement = -1;

    public MinStack() {
        this.stack = new int[8];
        this.minStack = new int[8];
    }
    
    public void push(int val) {
        lastElement++;
        if (stack.length <= lastElement) {
            int[] newStack = new int[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[lastElement] = val;

        val = Math.min(val, minLastElement == -1 ? val : minStack[minLastElement]);
        minLastElement++;
        if (minStack.length <= minLastElement) {
            int[] newStack = new int[minStack.length * 2];
            System.arraycopy(minStack, 0, newStack, 0, minStack.length);
            minStack = newStack;
        }
        minStack[minLastElement] = val;
    }

    public void pop() {
        stack[lastElement] = 0;
        lastElement--;

        minStack[minLastElement] = 0;
        minLastElement--;
    }
    
    public int top() {
        return stack[lastElement];
    }
    
    public int getMin() {
        return minStack[minLastElement];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */