// LeetCode Problem: https://leetcode.com/problems/search-a-2d-matrix/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int low = 0, high = row * col -1;

        while(low <= high){
            int mid = (low + high)/2;
            if(matrix[mid/col][mid%col] == target)
                return true;
            else if (matrix[mid/col][mid%col] < target)
                low = mid + 1;
            else 
                high = mid - 1;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;
        boolean result = solution.searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + result);
    }
}
