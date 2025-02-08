package pl.bsjhx.katas.arraysandhashing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveTest {

    @ParameterizedTest
    @MethodSource("provideNumbers")
    void longestConsecutive(int expected, int[] numbers) {
        var solution = new LongestConsecutive();
        assertEquals(expected, solution.longestConsecutive(numbers));
    }

    private static Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(0, new int[]{}),
                Arguments.of(3, new int[]{1, 2, 3}),
                Arguments.of(7, new int[]{9,1,4,7,3,-1,0,5,8,-1,6}),
                Arguments.of(4, new int[]{9,1,-3,2,4,8,3,-1,6,-2,-4,7})

        );
    }
}