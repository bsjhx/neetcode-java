package pl.bsjhx.katas.bitmanipulation;

class BitsManipulationsEasy {
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

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0 ; i <= n; i++) {
            int t = i, c = 0;
            while (t != 0) {
                c++;
                t = t & (t-1);
            }
            res[i] = c;
        }

        return res;
    }

    public int missingNumber(int[] nums) {
        int sum = 0;
        int total = nums.length * (nums.length + 1) / 2;
        for (int num : nums) {
            sum += num;
        }
        return total - sum;
    }
}