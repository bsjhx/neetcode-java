package pl.bsjhx.bitmanipulation;

class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result = result ^ n;
        }

        return result;
    }

    public int hammingWeight(int n) {
        if (n < 0) {
            n = -n;
        }
        int r = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                r++;
            }
            n = n >> 1;
        }
        return r;
    }
}