package pl.bsjhx.katas.linkedlist;

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
