package pl.bsjhx.katas.neetcode.backtracking;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.backtracking.PathSum;
import pl.bsjhx.katas.neetcode.backtracking.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class PathSumTest {

    @Test
    void hasPathSum() {
        PathSum pathSum = new PathSum();
        TreeNode tree = new TreeNode(-2, null, new TreeNode(-3));

        assertTrue(pathSum.hasPathSum(tree, -5));
    }
}