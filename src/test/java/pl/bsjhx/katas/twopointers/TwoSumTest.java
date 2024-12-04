package pl.bsjhx.katas.twopointers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void twoSum() {
        TwoSum ts = new TwoSum();
        int[] res = ts.twoSum(new int[]{-10,-8,-2,1,2,5,6}, 0);
        System.out.println(Arrays.toString(res));
    }
}