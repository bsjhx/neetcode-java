package pl.bsjhx.katas.neetcode.coreskills;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    @Test
    void testAll() {
        var heap = new MinHeap();
        assertEquals(-1, heap.top());
        heap.push(10);
        assertEquals(10, heap.top());
        heap.push(20);
        assertEquals(10, heap.top());
        heap.push(30);
        assertEquals(10, heap.top());
        heap.push(15);
        assertEquals(10, heap.top());
        heap.push(5);
        assertEquals(5, heap.top());

        assertEquals(5, heap.pop());
        assertEquals(10, heap.pop());
        assertEquals(15, heap.pop());
        assertEquals(20, heap.pop());
        assertEquals(30, heap.pop());
        assertEquals(-1, heap.pop());
    }

    @Test
    void testArray() {
        var heap = new MinHeap();
        List<Integer> list = new ArrayList<>(3);
        list.add(5);
        list.add(99);
        list.add(1);

        heap.heapify(list);
        assertEquals(1, heap.top());
    }
}