package pl.bsjhx.katas.neetcode.linkedlist;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.linkedlist.ListNode;
import pl.bsjhx.katas.neetcode.linkedlist.RemoveNthFromEnd;

import static org.junit.jupiter.api.Assertions.*;

class RemoveNthFromEndTest {

    @Test
    void removeNthFromEnd() {
        var solution = new RemoveNthFromEnd();
        ListNode l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        l = solution.removeNthFromEnd(l, 1);
        assertListOrder(new int[]{1, 2, 3}, l);

        l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        l = solution.removeNthFromEnd(l, 2);
        assertListOrder(new int[]{1, 2, 3, 5}, l);

        l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))));
        l = solution.removeNthFromEnd(l, 1);
        assertListOrder(new int[]{1, 2, 3, 4, 5, 6, 7}, l);
    }

    private void assertListOrder(int[] expected, ListNode l) {
        for (int e : expected) {
            assertEquals(e, l.val);
            l = l.next;
        }
        assertNull(l);
    }
}