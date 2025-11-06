package pl.bsjhx.katas.linkedlist;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;

        current = head;
        previous = null;
        for (int i = 1; i < n; i++) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            head = head.next;
        } else {
            previous.next = current.next;
        }

        current = head;
        previous = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
