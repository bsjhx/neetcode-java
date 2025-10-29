package pl.bsjhx.katas.linkedlist;

import java.util.List;

class ReorderList {

    public void reorderListN(ListNode head) {
        if (null == head || null == head.next) {
            return;
        }
        var fast = head;
        var slow = head;

        while (true) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast.next == null) {
                break;
            }

            if (fast.next.next == null) {
                slow = slow.next;
                break;
            }

        }
        var head2 = slow;
        head2 = reverse(head2);

        var curr1 = head;
        var next1 = curr1.next;
        var curr2 = head2;
        var next2 = curr2.next;

        while (curr1.next != null && curr2.next != null) {
            curr1.next = curr2;
            curr2.next = next1;

            var temp = next1;
            curr1 = temp;
            next1 = temp.next;

            var temp2 = next2;
            curr2 = temp2;
            next2 = temp2.next;
        }

        curr1.next = curr2;
        curr1.next.next = null;

    }

    private ListNode reverse(ListNode head) {
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

    // This is O(n*n) :D
    public void reorderList(ListNode head) {
        var lastNode = head;
        var preLast = head;
        while (lastNode.next != null) {
            preLast = lastNode;
            lastNode = lastNode.next;
        }

        var curr = head;
        var next = head.next;

        while (curr.next != null && curr.next.next != null) {
            // do a job
            curr.next = lastNode;
            lastNode.next = next;
            preLast.next = null;

            // move to next
            var temp = next;
            curr = temp;
            next = temp.next;

            // find new last
            lastNode = head;
            preLast = head;
            while (lastNode.next != null) {
                preLast = lastNode;
                lastNode = lastNode.next;
            }
        }

    }
}