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

        assertEquals(of(-10, -5), multiRange.next());
        assertEquals(of(1, 50), multiRange.next());

        assertTrue(multiRange.isEmpty());
    }
}