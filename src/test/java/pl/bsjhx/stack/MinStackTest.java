package pl.bsjhx.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    @Test
    void push() {
        MinStack minStack = new MinStack();
        minStack.push(5);
        assertEquals(5, minStack.top());
        assertEquals(5, minStack.getMin());
        minStack.push(10);
        assertEquals(10, minStack.top());
        minStack.push(1);
        assertEquals(1, minStack.getMin());
        minStack.pop();
        assertEquals(5, minStack.top());
    }

    @Test
    void testExtending() {
        MinStack minStack = new MinStack();
        for (int i = 0; i < 64; i++) {
            minStack.push(i);
            assertEquals(i, minStack.top());
            assertEquals(0, minStack.getMin());
        }

        for (int i = 63; i >= 0; i--) {
            assertEquals(i, minStack.top());
            minStack.pop();
        }

    }
}