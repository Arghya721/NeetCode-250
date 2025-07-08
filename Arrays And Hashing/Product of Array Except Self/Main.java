// LeetCode Problem: https://leetcode.com/problems/product-of-array-except-self/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int temp = 1;
        int[] ans = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            ans[i] = temp;
            temp *= nums[i];
        }

        temp = 1;

        for(int i=nums.length-1; i>=0; i--){
            ans[i] *= temp;
            temp *= nums[i];
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Output: 24 12 8 6
    }
}
