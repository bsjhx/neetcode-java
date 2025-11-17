package pl.bsjhx.katas.neetcode.coreskills;

import java.util.List;

class MinHeap {

    private HeapNode head;

    public MinHeap() {
        head = null;
    }

    public void push(int val) {
        if (head == null) {
            head = new HeapNode(val, null);
        } else {
            var curr = head;
            HeapNode prev = null;
            while (curr != null && curr.value < val) {
                prev = curr;
                curr = curr.next;
            }
            if (prev != null) {
                prev.next = new HeapNode(val, curr);
            } else {
                head = new HeapNode(val, curr);
            }
        }
    }

    public Integer pop() {
        if (head == null) {
            return -1;
        }
        var toReturn = head.value;

        head = head.next;

        return toReturn;
    }

    public Integer top() {
        if (head == null) {
            return -1;
        }
        return head.value;
    }

    public void heapify(List<Integer> nums) {
        for (int n : nums) {
            push(n);
        }
    }

    private static class HeapNode {
        int value;
        HeapNode next;

        public HeapNode(int value, HeapNode next) {
            this.value = value;
            this.next = next;
        }
    }
}