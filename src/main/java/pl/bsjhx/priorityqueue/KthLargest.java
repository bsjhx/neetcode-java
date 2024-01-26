package pl.bsjhx.priorityqueue;

import java.util.*;

class KthLargest {

    Queue<Integer> heap;

    int k;

    public KthLargest(int k, int[] nums) {
        this.heap = new PriorityQueue<>();
        this.k = k;

        for (int val : nums) {
            add(val);
        }

    }

    public int add(int val) {
        if (heap.size() < k) heap.offer(val);
        else if (val > heap.peek()) {
            heap.poll();
            heap.add(val);
        }

        return heap.peek();
    }
}
