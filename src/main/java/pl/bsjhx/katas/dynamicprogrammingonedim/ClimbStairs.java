package pl.bsjhx.katas.dynamicprogrammingonedim;

class ClimbStairs {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int i = 3;
        int[] arr = new int[]{1, 2};

        while (i <= n) {
            int temp = arr[1];
            arr[1] = arr[1] + arr[0];
            arr[0] = temp;
            i++;
        }

        return arr[1];
    }

    public int minCostClimbingStairs(int[] cost) {
        int one = 0;
        int two = 0;

        for (int i = cost.length - 1; i >= 0; i--) {
            cost[i] += Math.min(one, two);
            two = one;
            one = cost[i];
        }

        return Math.min(cost[0], cost[1]);
    }
}