package pl.bsjhx.katas.neetcode.arraysandhashing;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.arraysandhashing.ProductExceptSelf;

import java.util.Arrays;

class ProductExceptSelfTest {

    @Test
    void productExceptSelf() {
        ProductExceptSelf pes = new ProductExceptSelf();
        int[] ints = pes.productExceptSelf(new int[]{5, 9, 2, -9, -9, -7, -8, 7, -9, 10});
        System.out.println(Arrays.toString(ints));
    }
}