package pl.bsjhx.katas.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubsetsTest {

    @Test
    void subsets() {
        Subsets s = new Subsets();
        List<List<Integer>> subsets = s.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}