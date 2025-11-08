package pl.bsjhx.katas.neetcode.twopointers;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.twopointers.TwoSum;

import java.util.Arrays;

class TwoSumTest {

    @Test
    void twoSum() {
        TwoSum ts = new TwoSum();
        int[] res = ts.twoSum(new int[]{-10,-8,-2,1,2,5,6}, 0);
        System.out.println(Arrays.toString(res));
    }
}