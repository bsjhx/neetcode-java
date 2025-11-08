package pl.bsjhx.katas.neetcode.graphs;
// Definition for a Node.

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class CloneGraph {
    public Node cloneGraph(Node node) {
        Set<Node> visited = new HashSet<>();
        visited.add(node);

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        Queue<Node> queueCloned = new LinkedList<>();
        Node clonedRoot = new Node(node.val);
        queueCloned.add(clonedRoot);

        Map<Node, Node> alreadyCloned = new HashMap<>();
        alreadyCloned.put(node, clonedRoot);

        while (!queue.isEmpty() && !queueCloned.isEmpty()) {
            Node current = queue.poll();
            Node clonedCurrent = queueCloned.poll();

            for (Node n : current.neighbors) {
                Node nCloned = null;
                if (!alreadyCloned.containsKey(n)) {
                    nCloned = new Node(n.val);
                    alreadyCloned.put(n, nCloned);
                    clonedCurrent.neighbors.add(nCloned);
                } else {
                    clonedCurrent.neighbors.add(alreadyCloned.get(n));
                }

                if (!visited.contains(n)) {
                    queue.add(n);
                    queueCloned.add(nCloned);
                    visited.add(n);
                }
            }
        }

        return clonedRoot;
    }
}