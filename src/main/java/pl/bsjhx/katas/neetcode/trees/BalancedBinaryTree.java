package pl.bsjhx.katas.neetcode.trees;

class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        int res = balancedCount(root);
        return res != -1;
    }

    private int balancedCount(TreeNode root) {
        if (root == null) {
            return 1;
        }
        // not balanced
        int l = balancedCount(root.left);
        int r = balancedCount(root.right);
        if (Math.abs(l - r) > 1 || l == -1 || r == -1) {
            return -1;
        }
        return 1 + Math.max(l, r);
    }
}