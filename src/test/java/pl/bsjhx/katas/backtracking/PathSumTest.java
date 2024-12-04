package pl.bsjhx.katas.backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathSumTest {

    @Test
    void hasPathSum() {
        PathSum pathSum = new PathSum();
        TreeNode tree = new TreeNode(-2, null, new TreeNode(-3));

        assertTrue(pathSum.hasPathSum(tree, -5));
    }
}