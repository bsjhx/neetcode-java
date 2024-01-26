package pl.bsjhx.backtracking;

class PathSum {

    int currentSum = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root.left && null == root.right) {
            if (targetSum == currentSum + root.val) {
                return true;
            }
        }
        currentSum += root.val;
        if (null != root.left) {
            boolean r = hasPathSum(root.left, targetSum);
            if (r) return true;
        }
        if (null != root.right) {
            boolean l = hasPathSum(root.right, targetSum);
            if (l) return true;
        }
        currentSum -= root.val;
        return false;
    }
}
