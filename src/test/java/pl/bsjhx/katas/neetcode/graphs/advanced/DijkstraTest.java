package pl.bsjhx.katas.neetcode.graphs.advanced;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.graphs.advanced.Dijkstra;

import java.util.List;
import java.util.Map;

class DijkstraTest {

    @Test
    void shortestPathList() {
        List<List<Integer>> lists = List.of(List.of(0, 1, 10), List.of(0, 2, 3), List.of(1, 3, 2), List.of(2, 1, 4), List.of(2, 3, 8), List.of(2, 4, 2), List.of(3, 4, 5));
        Dijkstra d = new Dijkstra();
        Map<Integer, Integer> integerIntegerMap = d.shortestPath(5, lists, 0);

        System.out.println(integerIntegerMap);
    }
}
