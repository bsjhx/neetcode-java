package pl.bsjhx.katas.neetcode.priorityqueue;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.priorityqueue.KthLargest;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestTest {

    @Test
    void add() {
        int[] empty = new int[0];
        KthLargest kth = new KthLargest(3, empty);
        assertEquals(5, kth.add(5));
        assertEquals(5, kth.add(9));
        assertEquals(5, kth.add(19));
        assertEquals(5, kth.add(1));
        assertEquals(9, kth.add(20));
        assertEquals(9, kth.add(8));
        assertEquals(19, kth.add(35));
        assertEquals(19, kth.add(2));
    }
}