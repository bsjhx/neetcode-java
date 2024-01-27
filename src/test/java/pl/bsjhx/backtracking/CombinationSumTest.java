package pl.bsjhx.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumTest {

    @Test
    void combinationSum() {
        CombinationSum cs = new CombinationSum();
        List<List<Integer>> result = cs.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(result);
    }
}