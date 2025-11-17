package pl.bsjhx.katas.neetcode.coreskills;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void test1() {
        var hashTable = new HashTable(2);
        assertFullInsert(hashTable, 5, -1, 5);
        assertFullInsert(hashTable, 6, -1, 5);
        assertFullInsert(hashTable, 7, -1, 10);
        assertFullInsert(hashTable, 6, 5, 12);

        assertEquals(5, hashTable.get(5));
        assertEquals(10, hashTable.get(7));
        assertEquals(12, hashTable.get(6));
        assertEquals(3, hashTable.getSize());
        assertEquals(8, hashTable.getCapacity());

        assertTrue(hashTable.remove(5));
        assertEquals(-1, hashTable.get(5));
    }

    @Test
    void testDelete() {
        var hashTable = new HashTable(20);
        hashTable.insert(2, 20);
        hashTable.insert(22, 220);
        hashTable.insert(42, 420);
        hashTable.insert(62, 620);
        hashTable.insert(82, 820);
        hashTable.insert(102, 1020);

        assertTrue(hashTable.remove(62));
        assertFalse(hashTable.remove(62));
        assertEquals(-1, hashTable.get(62));
        assertFalse(hashTable.remove(122));
        assertFalse(hashTable.remove(123));
    }

    @Test
    void resize() {
        var hashTable = new HashTable(20);
        hashTable.insert(2, 20);
        hashTable.insert(22, 220);
        hashTable.insert(42, 420);
        hashTable.insert(62, 620);
        hashTable.insert(82, 820);
        hashTable.insert(102, 1020);

        hashTable.insert(3, 30);
        hashTable.insert(23, 230);
        hashTable.insert(43, 430);
        hashTable.insert(63, 630);
        hashTable.insert(83, 830);
        hashTable.insert(103, 1030);

        hashTable.insert(43, 2555);

        assertEquals(20, hashTable.get(2));
        assertEquals(220, hashTable.get(22));
        assertEquals(420, hashTable.get(42));
        assertEquals(620, hashTable.get(62));
        assertEquals(820, hashTable.get(82));
        assertEquals(1020, hashTable.get(102));
        assertEquals(30, hashTable.get(3));
        assertEquals(230, hashTable.get(23));
        assertEquals(2555, hashTable.get(43));
        assertEquals(630, hashTable.get(63));
        assertEquals(830, hashTable.get(83));
        assertEquals(1030, hashTable.get(103));
    }

    private static void assertFullInsert(HashTable hashTable, int key, int oldValue, int newValue) {
        assertEquals(oldValue, hashTable.get(key));
        hashTable.insert(key, newValue);
        assertEquals(newValue, hashTable.get(key));
    }
}