package pl.bsjhx.katas.twopointers;

public class ContainerWithMostWater {

    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = (right - left) * Math.min(heights[left], heights[right]);
        
        while (left < right) {
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
            int currentArea = (right - left) * Math.min(heights[left], heights[right]);
            max = Math.max(max, currentArea);
        }        
        
        return max;
    }
}
