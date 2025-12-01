package pl.bsjhx.katas.adventofcode;

import java.io.IOException;
import java.util.List;

public interface Advent {

    List<List<Integer>> DIRECTIONS = List.of(
            List.of(-1, 0), // UP
            List.of(0, 1), // RIGHT
            List.of(1, 0), // DOWN
            List.of(0, -1)  // LEFT
    );

    default long calculatePartOne() throws IOException {
        return 0;
    }

    default long calculatePartTwo() throws IOException {
        return 0;
    }

    static boolean isInMap(Integer i, Integer j, final List<List<String>> map) {
        return i >= 0 && j >= 0 && i < map.size() && j < map.getFirst().size();
    }
}
