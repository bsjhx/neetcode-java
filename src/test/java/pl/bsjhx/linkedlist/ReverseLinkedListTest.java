package pl.bsjhx.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

    @Test
    void reverseListTest() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode actual = solution.reverseList(head);
        int expectedVal = 5;

        while (actual != null) {
            assertEquals(expectedVal, actual.val);
            expectedVal--;
            actual = actual.next;
        }

    }

}