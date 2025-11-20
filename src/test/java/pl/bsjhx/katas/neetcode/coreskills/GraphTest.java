package pl.bsjhx.katas.neetcode.coreskills;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GraphTest {

    @Test
    void add_and_remove() {
        var graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        assertFalse(graph.removeEdge(6, 1));
        assertFalse(graph.removeEdge(1, 6));
        assertTrue(graph.removeEdge(1, 2));
        assertTrue(graph.removeEdge(1, 3));
        assertFalse(graph.removeEdge(1, 2));

        System.out.println();
    }

    @Test
    void are_connected() {
        var graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        graph.addEdge(4, 2);
        assertTrue(graph.hasPath(4, 2));
        graph.removeEdge(4, 2);
        assertFalse(graph.hasPath(4, 2));

        assertFalse(graph.hasPath(7, 2));
        assertTrue(graph.hasPath(1, 2));
    }
}