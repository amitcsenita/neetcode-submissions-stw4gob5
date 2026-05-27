class Solution {

    int getValue(int[][]matrix, int cols, int index) {
        int row = index / cols;
        int col = index % cols;

        return matrix[row][col];

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int valueAtMid = getValue(matrix, cols, mid);

            if (valueAtMid == target) {
                return true;
            } else if (valueAtMid < target) {
                left = mid + 1;
            }  else {
                right = mid - 1;
            }
        }
        return false;
    }
}
