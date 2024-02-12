package pl.bsjhx.arraysandhashing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProductExceptSelfTest {

    @Test
    void productExceptSelf() {
        ProductExceptSelf pes = new ProductExceptSelf();
        int[] ints = pes.productExceptSelf(new int[]{5, 9, 2, -9, -9, -7, -8, 7, -9, 10});
        System.out.println(Arrays.toString(ints));
    }
}