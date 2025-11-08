package pl.bsjhx.katas.neetcode.backtracking;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.backtracking.CombinationSum;

import java.util.List;

class CombinationSumTest {

    @Test
    void combinationSum() {
        CombinationSum cs = new CombinationSum();
        List<List<Integer>> result = cs.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(result);
    }
}