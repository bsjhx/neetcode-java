package pl.bsjhx.katas.linkedlist;

import org.junit.jupiter.api.Test;

class MergeTwoListsTest {

    @Test
    void mergeTwoLists() {
        MergeTwoLists mtl = new MergeTwoLists();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = mtl.mergeTwoLists(l1, l2);
        System.out.println("ssdd");
    }
}