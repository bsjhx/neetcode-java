package pl.bsjhx.katas.neetcode.twopointers;

import org.junit.jupiter.api.Test;
import pl.bsjhx.katas.neetcode.twopointers.ContainerWithMostWater;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    @Test
    void maxArea() {
        ContainerWithMostWater container = new ContainerWithMostWater();
        
        // Test case 1: Simple case
        int[] heights1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        assertEquals(49, container.maxArea(heights1));
        
        // Test case 2: All heights are the same
        int[] heights2 = {4, 4, 4, 4};
        assertEquals(12, container.maxArea(heights2));
        
        // Test case 3: Decreasing heights
        int[] heights3 = {5, 4, 3, 2, 1};
        assertEquals(6, container.maxArea(heights3));
        
        // Test case 4: Increasing heights
        int[] heights4 = {1, 2, 3, 4, 5};
        assertEquals(6, container.maxArea(heights4));
        
        // Test case 5: Single element
        int[] heights5 = {10};
        assertEquals(0, container.maxArea(heights5));
        
    }
}