package pl.bsjhx.katas.adventofcode.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {

    @Test
    void range_should_be_in_proper_order() {
        assertThrowsExactly(IllegalArgumentException.class, () -> Range.of(5L, 2L));
        assertDoesNotThrow(() -> Range.of(5L, 20L));
    }

    @Test
    void should_check_if_in_range() {
        var range = Range.of(1, 10);
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

        queue.add(Range.of(20, 99));
        queue.add(Range.of(10, 20));
        queue.add(Range.of(3, 5));
        queue.add(Range.of(5, 19));
        queue.add(Range.of(7, 9));

        assertEquals(3, Objects.requireNonNull(queue.poll()).getStart());
        assertEquals(5, Objects.requireNonNull(queue.poll()).getStart());
        assertEquals(7, Objects.requireNonNull(queue.poll()).getStart());
        assertEquals(10, Objects.requireNonNull(queue.poll()).getStart());
        assertEquals(20, Objects.requireNonNull(queue.poll()).getStart());
    }

    public static Stream<Arguments> mergeTestCases() {
        return Stream.of(
                Arguments.of(
                        Range.of(1, 10),
                        Range.of(5, 6),
                        Range.of(1, 10),
                        true
                ),
                Arguments.of(
                        Range.of(1, 10),
                        Range.of(0, 11),
                        Range.of(0, 11),
                        true
                ),
                Arguments.of(
                        Range.of(1, 10),
                        Range.of(-5, 6),
                        Range.of(-5, 10),
                        true
                ),
                Arguments.of(
                        Range.of(1, 10),
                        Range.of(5, 100),
                        Range.of(1, 100),
                        true
                ),
                Arguments.of(
                        Range.of(1, 10),
                        Range.of(-100, 100),
                        Range.of(-100, 100),
                        true
                )
        );
    }
}