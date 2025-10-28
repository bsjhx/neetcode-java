package pl.bsjhx.katas.linkedlist;

class ReorderList {

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