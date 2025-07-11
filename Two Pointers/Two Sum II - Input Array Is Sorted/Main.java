// LeetCode Problem: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while(i < j){
            if(numbers[i] + numbers[j] == target){
                return new int[]{i+1, j+1};
            } else if (numbers[i] + numbers[j] > target){
                j--;
            } else {
                i++;
            }
        }
        return new int[]{-1, -1};
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(numbers, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
