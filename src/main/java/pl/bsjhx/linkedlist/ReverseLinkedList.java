package pl.bsjhx.linkedlist;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/">206. Reverse Linked List</a>
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}