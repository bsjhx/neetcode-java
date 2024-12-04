package pl.bsjhx.katas.linkedlist;

class ReorderList {
    public void reorderList(ListNode head) {
        ListNode lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }


    }
}