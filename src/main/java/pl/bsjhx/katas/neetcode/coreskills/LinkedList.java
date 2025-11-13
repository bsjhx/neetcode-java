package pl.bsjhx.katas.neetcode.coreskills;

import java.util.ArrayList;

public class LinkedList {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public int get(int index) {
        if (index < 0 || null == head) {
            return -1;
        }
        var curr = head;
        for (int i = 0; i < index; i++) {
            if (curr == null) {
                return -1;
            }
            curr = curr.next;
        }
        return null == curr ? -1 : curr.value;
    }

    public void insertHead(int val) {
        if (null == head) {
            head = new Node();
            head.value = val;
        } else {
            var newNode = new Node();
            newNode.value = val;
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertTail(int val) {
        if (null == head) {
            head = new Node();
            head.value = val;
            return;
        }

        var curr = head;
        while (null != curr.next) {
            curr = curr.next;
        }

        var newNode = new Node();
        newNode.value = val;
        curr.next = newNode;
    }

    public boolean remove(int index) {
        if (index < 0 || null == head) {
            return false;
        }

        if (0 == index) {
            head = head.next;
            return true;
        }

        Node curr = head;
        Node prev = null;
        for (int i = 0; i < index; i++) {
            prev = curr;
            curr = curr.next;
            if (null == curr) {
                return false;
            }
        }

        prev.next = curr.next;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> ret = new ArrayList<>();
        var curr = head;

        while (null != curr) {
            ret.add(curr.value);
            curr = curr.next;
        }

        return ret;
    }

    private static class Node {
        int value;
        Node next;
    }
}
