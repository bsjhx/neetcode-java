package pl.bsjhx.katas.trees;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeMapTest {

    @Test
    void testInserting() {
        TreeMap map = new TreeMap();
        assertEquals(-1, map.get(5));

        map.insert(5, 50);
        assertEquals(50, map.get(5));

        map.insert(6, 60);
        assertEquals(60, map.get(6));

        map.insert(2, 20);
        assertEquals(20, map.get(2));

        map.insert(2, 200);
        assertEquals(200, map.get(2));

        map.insert(5, 500);
        assertEquals(500, map.get(5));
    }

    @Test
    void testMinAndMax() {
        TreeMap map = new TreeMap();
        assertEquals(-1, map.getMin());
        assertEquals(-1, map.getMax());

        map = createTestMap();
        assertEquals(10, map.getMin());
        assertEquals(300, map.getMax());
    }

    @Test
    void testRemove() {
        TreeMap map = createTestMap();
        assertEquals(200, map.get(20));
        map.remove(20);
        assertEquals(-1, map.get(20));

        map = createTestMap();
        assertEquals(50, map.get(5));
        map.remove(5);
        assertEquals(-1, map.get(5));

        map = createTestMap();
        assertEquals(150, map.get(15));
        map.remove(15);
        assertEquals(-1, map.get(15));

        // Removing not-existing node does not break TreeMap
        map.remove(666);

        // Case from submitting
        map = new TreeMap();
        map.insert(1, 2);
        map.insert(4, 2);
        map.remove(1);
        assertEquals(-1, map.get(1));
    }

    @Test
    void testInOrder() {
        TreeMap map = createTestMap();
        assertEquals(List.of(1, 2, 5, 9, 10, 11, 15, 20, 30), map.getInorderKeys());
    }

    private TreeMap createTestMap() {
        TreeMap map = new TreeMap();
        addNode(map, 10);
        addNode(map, 5);
        addNode(map, 20);
        addNode(map, 1);
        addNode(map, 9);
        addNode(map, 30);
        addNode(map, 15);
        addNode(map, 11);
        addNode(map, 2);

        return map;
    }

    private void addNode(TreeMap map, int key) {
        map.insert(key, key * 10);
    }
}