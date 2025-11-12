package pl.bsjhx.katas.neetcode.tries;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {

    private final Node rootNode;

    public WordDictionary() {
        this.rootNode = new Node();
    }

    public void addWord(String word) {
        var words = word.split("");
        addWord(rootNode, words, 0);
    }

    public boolean search(String word) {
        var letters = word.split("");
        return search(rootNode, letters, 0);
    }

    private boolean search(Node node, String[] letters, int i) {
        if (i == letters.length) {
            return node.isWord;
        }

        var letter = letters[i];

        if (".".equals(letter)) {
            for (var n : node.nodes.values()) {
                return search(n, letters, i + 1);
            }
        }

        if (node.nodes.containsKey(letter)) {
            return search(node.nodes.get(letter), letters, i + 1);
        } else {
            return false;
        }
    }

    private void addWord(Node node, String[] letters, int i) {
        if (i == letters.length) {
            return;
        }

        var letter = letters[i];
        if (node.nodes.containsKey(letter)) {
            addWord(node.nodes.get(letter), letters, i + 1);
        } else {
            var newNode = new Node();
            node.nodes.put(letter, newNode);
            if (i == letters.length - 1) {
                newNode.isWord = true;
            }
            addWord(node.nodes.get(letter), letters, i + 1);
        }
    }

    private static class Node {
        Map<String, Node> nodes;
        boolean isWord;

        public Node() {
            this.isWord = false;
            this.nodes = new HashMap<>();
        }
    }
}
