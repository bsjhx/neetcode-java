package pl.bsjhx.katas.neetcode.slidingwindow;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.slidingwindow.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockTest {

    @Test
    void maxProfit() {
        Solution solution = new Solution();
        assertEquals(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}), 5);
    }
}