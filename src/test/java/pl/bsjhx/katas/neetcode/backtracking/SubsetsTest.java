package pl.bsjhx.katas.neetcode.backtracking;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.backtracking.Subsets;

import java.util.List;

class SubsetsTest {

    @Test
    void subsets() {
        Subsets s = new Subsets();
        List<List<Integer>> subsets = s.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}