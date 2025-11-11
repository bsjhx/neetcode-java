package pl.bsjhx.katas.neetcode.twopointers;

public class TrappingWater {
    public int trap(int[] height) {
        int l = 0;
        int r = 1;

        if (height.length == 1) {
            return 0;
        }

        while (l < height.length && height[l] == 0) {
            l++;
        }

        if (l >= height.length) {
            return 0;
        }

        r = l + 1;

        int landSum = 0;
        int water = 0;
        while (r < height.length) {
            if (height[r] >= height[l]) {
                water += Math.min(height[r], height[l]) * (r - l - 1);
                water -= landSum;
                landSum = 0;
                l = r;
            } else {
                landSum += height[r];
            }
            r++;
            if (r >= height.length) {
                landSum = 0;
                l++;
                r = l + 1;
            }
        }

        r = height.length - 1;
        l = r - 1;
        landSum = 0;

        while (true) {
            if (height[l] == height[r]) {
                return water;
            }
            if (height[l] > height[r]) {
                water += Math.min(height[r], height[l]) * (r - l - 1) - landSum;
                return water;
            } else {
                landSum += height[l];
            }
            l--;
            if (l == -1) {
                return water;
            }
        }

    }
}
