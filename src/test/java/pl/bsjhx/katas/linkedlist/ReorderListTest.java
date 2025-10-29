package pl.bsjhx.katas.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ReorderListTest {

    @Test
    void reorderList() {
        ReorderList solution = new ReorderList();

        // case 1
        ListNode l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        solution.reorderList(l);
        int[] expected = new int[]{1, 4, 2, 3};
        assertListOrder(expected, l);

        // case 2
        l = new ListNode(1, new ListNode(2));
        solution.reorderList(l);
        expected = new int[]{1, 2};
        assertListOrder(expected, l);

        // case 1 - n
        l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        solution.reorderListN(l);
        expected = new int[]{1, 4, 2, 3};
        assertListOrder(expected, l);

        // case 2 - n
        l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        solution.reorderListN(l);
        expected = new int[]{1, 5, 2, 4, 3};
        assertListOrder(expected, l);

        l = new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(8, new ListNode(10)))));
        solution.reorderListN(l);
        expected = new int[]{2,10,4,8,6};
        assertListOrder(expected, l);
    }

    private void assertListOrder(int[] expected, ListNode l) {
        for (int e : expected) {
            assertEquals(e, l.val);
            l = l.next;
        }
        assertNull(l);
    }

}