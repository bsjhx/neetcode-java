package pl.bsjhx.katas.adventofcode.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    @Test
    void range_should_be_in_proper_order() {
        assertThrowsExactly(IllegalArgumentException.class, () -> new Range<>(5L, 2L));
        assertDoesNotThrow(() -> new Range<>(5L, 20L));
    }

    @Test
    void should_check_if_in_range() {
        var range = new Range<>(1, 10);
        assertTrue(range.isInRange(5));
        assertTrue(range.isInRange(1));
        assertTrue(range.isInRange(9));
        assertFalse(range.isInRange(10));
        assertFalse(range.isInRange(0));
        assertFalse(range.isInRange(11));
        assertFalse(range.isInRange(-50));

        range.setEndIncluded(true);
        assertTrue(range.isInRange(5));
        assertTrue(range.isInRange(1));
        assertTrue(range.isInRange(9));
        assertTrue(range.isInRange(10));
        assertFalse(range.isInRange(0));
        assertFalse(range.isInRange(11));
        assertFalse(range.isInRange(-50));

        range.setStartIncluded(false);
        range.setEndIncluded(true);
        assertTrue(range.isInRange(5));
        assertFalse(range.isInRange(1));
        assertTrue(range.isInRange(9));
        assertTrue(range.isInRange(10));
        assertFalse(range.isInRange(0));
        assertFalse(range.isInRange(11));
        assertFalse(range.isInRange(-50));

        range.setStartIncluded(false);
        range.setEndIncluded(false);
        assertTrue(range.isInRange(5));
        assertFalse(range.isInRange(1));
        assertTrue(range.isInRange(9));
        assertFalse(range.isInRange(10));
        assertFalse(range.isInRange(0));
        assertFalse(range.isInRange(11));
        assertFalse(range.isInRange(-50));
    }

    @ParameterizedTest
    @MethodSource("mergeTestCases")
    void should_marge_ranges(Range<Integer> first, Range<Integer> second, Range<Integer> expected, boolean merged) {
        assertEquals(merged, first.mergeWith(second));
        assertEquals(expected.getStart(), first.getStart());
        assertEquals(expected.getEnd(), first.getEnd());
    }

    @Test
    void priorityQueueShouldReturnRangesInAscendingOrderByStart() {
        PriorityQueue<Range<Integer>> queue = new PriorityQueue<>();

        queue.add(new Range<>(20, 99));
        queue.add(new Range<>(10, 20));
        queue.add(new Range<>(3, 5));
        queue.add(new Range<>(5, 19));
        queue.add(new Range<>(7, 9));

        assertEquals(3, Objects.requireNonNull(queue.poll()).getStart());
        assertEquals(5, Objects.requireNonNull(queue.poll()).getStart());
        assertEquals(7, Objects.requireNonNull(queue.poll()).getStart());
        assertEquals(10, Objects.requireNonNull(queue.poll()).getStart());
        assertEquals(20, Objects.requireNonNull(queue.poll()).getStart());
    }

    public static Stream<Arguments> mergeTestCases() {
        return Stream.of(
                Arguments.of(
                        new Range<>(1, 10),
                        new Range<>(0, 11),
                        new Range<>(0, 11),
                        true
                ),
                Arguments.of(
                        new Range<>(1, 10),
                        new Range<>(5, 6),
                        new Range<>(1, 10),
                        false
                ),
                Arguments.of(
                        new Range<>(1, 10),
                        new Range<>(-5, 6),
                        new Range<>(-5, 10),
                        true
                ),
                Arguments.of(
                        new Range<>(1, 10),
                        new Range<>(5, 100),
                        new Range<>(1, 100),
                        true
                ));
    }
}