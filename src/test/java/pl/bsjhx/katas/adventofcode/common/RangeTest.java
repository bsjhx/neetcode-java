package pl.bsjhx.katas.adventofcode.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.MethodSource;

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
    }

    @ParameterizedTest
    @MethodSource("mergeTestCases")
    void should_marge_ranges(Range<Integer> first, Range<Integer> second, Range<Integer> expected) {
        first.mergeWith(second);
        assertEquals(expected.getStart(), first.getStart());
        assertEquals(expected.getEnd(), first.getEnd());
    }

    public static Stream<Arguments> mergeTestCases() {
        return Stream.of(
                Arguments.of(
                        new Range<>(1, 10),
                        new Range<>(0, 11),
                        new Range<>(0, 11)
                ),
                Arguments.of(
                        new Range<>(1, 10),
                        new Range<>(5, 6),
                        new Range<>(1, 10)
                ),
                Arguments.of(
                        new Range<>(1, 10),
                        new Range<>(-5, 6),
                        new Range<>(-5, 10)
                ),
                Arguments.of(
                        new Range<>(1, 10),
                        new Range<>(5, 100),
                        new Range<>(1, 100)
                ));
    }
}