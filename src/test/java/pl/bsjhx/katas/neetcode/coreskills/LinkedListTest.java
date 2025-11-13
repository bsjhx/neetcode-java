package pl.bsjhx.katas.neetcode.coreskills;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void testList() {
        var solution = new LinkedList();
        solution.insertHead(2);
        solution.insertHead(1);
        assertEquals(-1, solution.get(4));
        solution.insertTail(3);

        assertEquals(1, solution.get(0));
        assertEquals(2, solution.get(1));
        assertEquals(3, solution.get(2));

        assertTrue(solution.remove(0));

        assertEquals(2, solution.get(0));
        assertEquals(3, solution.get(1));

        assertTrue(solution.remove(1));
        assertEquals(2, solution.get(0));
        assertEquals(-1, solution.get(1));
    }

    @Test
    void testTail() {
        var solution = new LinkedList();
        solution.insertTail(1);
        solution.insertTail(2);
        solution.insertTail(3);

        assertEquals(1, solution.get(0));
        assertEquals(2, solution.get(1));
        assertEquals(3, solution.get(2));
    }

    @Test
    void testOutOfBound() {
        var solution = new LinkedList();

        // below 0
        assertEquals(-1, solution.get(-1));
        assertEquals(-1, solution.get(-100));
        assertEquals(-1, solution.get(-100000));

        assertFalse(solution.remove(-1));
        assertFalse(solution.remove(100));

        // empty
        assertEquals(-1, solution.get(0));
        assertEquals(-1, solution.get(1));
        assertEquals(-1, solution.get(2));
        assertFalse(solution.remove(0));
        assertFalse(solution.remove(1));
        assertFalse(solution.remove(2));

        // some elems
        solution.insertTail(1);
        solution.insertTail(2);
        solution.insertTail(3);
        assertFalse(solution.remove(3));
        assertEquals(-1, solution.get(3));
    }

    @Test
    void testToArray() {
        var solution = new LinkedList();
        assertEquals(new ArrayList<>(), solution.getValues());

        solution.insertTail(1);
        solution.insertTail(2);
        solution.insertTail(3);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        assertEquals(expected, solution.getValues());
    }

    @Test
    void name() {
        var solution = new LinkedList();
        solution.insertHead(1);
        assertFalse(solution.remove(2));
        assertFalse(solution.remove(1));
    }
}