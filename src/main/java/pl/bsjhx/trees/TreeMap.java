package pl.bsjhx.trees;

import java.util.LinkedList;
import java.util.List;

class TreeMap {

    private MapNode root;

    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        root = insert(root, key, val);
    }

    public int get(int key) {
        return get(root, key);
    }

    public int getMin() {
        MapNode min = getMin(root);
        return min != null ? min.value : -1;
    }

    public int getMax() {
        return getMax(root);
    }

    public void remove(int key) {
        root = remove(root, key);
    }

    public List<Integer> getInorderKeys() {
        List<Integer> keys = new LinkedList<>();
        return getInorderKeys(root, keys);
    }

    private List<Integer> getInorderKeys(MapNode root, List<Integer> keys) {
        if (root == null) {
            return List.of();
        }

        getInorderKeys(root.left, keys);
        keys.add(root.key);
        getInorderKeys(root.right, keys);

        return keys;
    }

    private MapNode insert(MapNode root, int key, int val) {
        if (root == null) {
            root = new MapNode(key, val);
        }

        if (key < root.key) {
            root.left = insert(root.left, key, val);
        }
        if (key > root.key) {
            root.right = insert(root.right, key, val);
        }
        if (key == root.key) {
            root.value = val;
        }

        return root;
    }

    private int get(MapNode root, int key) {
        if (root == null) {
            return -1;
        }
        if (root.key == key) {
            return root.value;
        }

        return key < root.key ? get(root.left, key) : get(root.right, key);
    }

    private MapNode remove(MapNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.key) {
            root.left = remove(root.left, key);
        } else if (key > root.key) {
            root.right = remove(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                MapNode minNode = getMin(root.right);
                root.value = minNode.value;
                root.key = minNode.key;
                root.right = remove(root.right, root.key);
            }
        }

        return root;
    }

    private MapNode getMin(MapNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            return getMin(root.left);
        }
        return root;
    }

    private int getMax(MapNode root) {
        if (root == null) {
            return -1;
        }
        if (root.right != null) {
            return getMax(root.right);
        }
        return root.value;
    }

}

class MapNode {
    int key;

    int value;

    MapNode left;

    MapNode right;

    public MapNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
