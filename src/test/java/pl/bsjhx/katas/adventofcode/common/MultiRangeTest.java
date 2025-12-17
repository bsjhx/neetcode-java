package pl.bsjhx.katas.adventofcode.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pl.bsjhx.katas.adventofcode.common.Range.of;

class MultiRangeTest {

    @Test
    void should_be_able_to_add_new_range_without_merging() {
        MultiRange<Integer> multiRange = new MultiRange<>();
        assertTrue(multiRange.isEmpty());

        assertFalse(multiRange.add(of(1, 5)));
        assertFalse(multiRange.add(of(9, 10)));
        assertFalse(multiRange.add(of(-10, -5)));
        assertFalse(multiRange.isEmpty());

        assertEquals(of(-10, -5), multiRange.next());
        assertEquals(of(1, 5), multiRange.next());
        assertEquals(of(9, 10), multiRange.next());

        assertTrue(multiRange.isEmpty());
    }

    @Test
    void should_be_able_to_add_new_range_with_merging() {
        MultiRange<Integer> multiRange = new MultiRange<>();
        assertTrue(multiRange.isEmpty());

        assertFalse(multiRange.add(of(1, 5)));
        assertTrue(multiRange.add(of(4, 50)));
        assertFalse(multiRange.add(of(-10, -5)));
        assertFalse(multiRange.isEmpty());
        assertEquals(2, multiRange.size());

        assertEquals(of(-10, -5), multiRange.next());
        assertEquals(of(1, 50), multiRange.next());

        assertTrue(multiRange.isEmpty());
    }

    @Test
    void should_be_able_to_add_new_range_with_merging_when_ranges_are_various() {
        MultiRange<Integer> multiRange = new MultiRange<>();
        assertTrue(multiRange.isEmpty());

        assertFalse(multiRange.add(of(1, 5)));
        assertFalse(multiRange.add(of(10, 50)));
        assertTrue(multiRange.add(of(4, 30)));
        assertEquals(1, multiRange.size());

        assertEquals(of(1, 50), multiRange.next());

        assertTrue(multiRange.isEmpty());
        assertEquals(0, multiRange.size());
    }

    @Test
    void should_be_able_to_add_new_range_with_merging_when_ranges_are_various_part_2() {
        MultiRange<Integer> multiRange = new MultiRange<>();
        assertTrue(multiRange.isEmpty());

        assertFalse(multiRange.add(of(1, 5)));
        assertFalse(multiRange.add(of(9, 11)));
        assertFalse(multiRange.add(of(16, 20)));
        assertFalse(multiRange.add(of(-100, -89)));
        assertFalse(multiRange.add(of(25, 36)));
        assertFalse(multiRange.add(of(100, 899)));
        assertEquals(6, multiRange.size());

        assertTrue(multiRange.add(of(-101, 900)));
        assertEquals(1, multiRange.size());

        assertEquals(of(-101, 900), multiRange.next());

        assertTrue(multiRange.isEmpty());
        assertEquals(0, multiRange.size());
    }

    @Test
    void should_be_able_to_add_new_range_with_merging_when_ranges_are_various_part_3() {
        MultiRange<Integer> multiRange = new MultiRange<>();
        assertTrue(multiRange.isEmpty());

        assertFalse(multiRange.add(of(1, 5)));
        assertFalse(multiRange.add(of(9, 11)));
        assertFalse(multiRange.add(of(16, 20)));
        assertFalse(multiRange.add(of(-100, -89)));
        assertFalse(multiRange.add(of(25, 36)));
        assertFalse(multiRange.add(of(100, 899)));
        assertEquals(6, multiRange.size());

        assertTrue(multiRange.add(of(-101, 900)));
        assertEquals(1, multiRange.size());

        assertEquals(of(-101, 900), multiRange.next());

        assertTrue(multiRange.isEmpty());
        assertEquals(0, multiRange.size());

        assertFalse(multiRange.add(of(1, 5)));
        assertTrue(multiRange.add(of(1, 5)));
        assertEquals(1, multiRange.size());

        assertTrue(multiRange.add(of(5, 10)));
        assertFalse(multiRange.add(of(11, 12)));
        assertEquals(2, multiRange.size());
    }

    @Test
    void should_add_single_value_ranges() {
        MultiRange<Integer> multiRange = new MultiRange<>();
        assertFalse(multiRange.add(of(1, 10)));
        assertTrue(multiRange.add(of(1 , 1)));
        assertEquals(1, multiRange.size());
    }
}