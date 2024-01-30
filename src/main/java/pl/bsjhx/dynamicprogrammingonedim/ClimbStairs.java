package pl.bsjhx.dynamicprogrammingonedim;

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
}