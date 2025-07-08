// LeetCode Problem: https://leetcode.com/problems/range-sum-query-2d-immutable/

class NumMatrix {
    private int[][] sumMat;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        sumMat = new int[rows + 1][cols + 1];

        for (int r = 0; r < rows; r++) {
            int prefix = 0;
            for (int c = 0; c < cols; c++) {
                prefix += matrix[r][c];
                int above = sumMat[r][c + 1];
                sumMat[r + 1][c + 1] = prefix + above;
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;

        int bottomRight = sumMat[row2][col2];
        int above = sumMat[row1 - 1][col2];
        int left = sumMat[row2][col1 - 1];
        int topLeft = sumMat[row1 - 1][col1 - 1];

        return bottomRight - above - left + topLeft;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // Output: 28
        System.out.println(numMatrix.sumRegion(0, 0, 1, 1)); // Output: 12
        System.out.println(numMatrix.sumRegion(1, 2, 2, 2)); // Output: 15
    }
}
