package pl.bsjhx.katas.binarysearch;

class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length * matrix[0].length - 1;
        int m;

        while (l <= r) {
            m = l + (r - l) / 2;
            int i = m / matrix[0].length;
            int j = i == 0 ? m : m - (i * matrix[0].length);
            if (matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return false;
    }
}