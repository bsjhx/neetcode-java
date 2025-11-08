package pl.bsjhx.katas.neetcode.tries;

import java.util.HashMap;

class Trie {

    TrieNodes rootNodes;

    public Trie() {
        rootNodes = new TrieNodes();
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        insert(rootNodes, chars, 0);
    }

    private void insert(TrieNodes rootNodes, char[] chars, int i) {
        if (i == chars.length) {
            return;
        }
        char c = chars[i];
        if (!rootNodes.children.containsKey(c)) {
            TrieNodes newNode = i == chars.length - 1 ? new TrieNodes(true) : new TrieNodes();
            rootNodes.children.put(c, newNode);
        } else if (i == chars.length - 1) {
            rootNodes.children.get(c).isWord = true;
        }

        TrieNodes current = rootNodes.children.get(c);
        insert(current, chars, i + 1);
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        return search(rootNodes, chars, 0);
    }

    private boolean search(TrieNodes rootNodes, char[] chars, int i) {
        if (null == rootNodes) {
            return false;
        }
        if (i == chars.length) {
            return rootNodes.isWord;
        }
        TrieNodes current = rootNodes.children.get(chars[i]);

        return search(current, chars, i + 1);
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        return startsWith(rootNodes, chars, 0);
    }

    private boolean startsWith(TrieNodes rootNodes, char[] chars, int i) {
        if (null == rootNodes) {
            return false;
        }
        TrieNodes current = rootNodes.children.get(chars[i]);
        if (i == chars.length - 1) {
            return null != current;
        }

        return startsWith(current, chars, i + 1);
    }
}

class TrieNodes {

    HashMap<Character, TrieNodes> children;

    boolean isWord;

    public TrieNodes() {
        this(false);
    }

    public TrieNodes(boolean isWord) {
        this.isWord = isWord;
        this.children = new HashMap<>();
    }
}
