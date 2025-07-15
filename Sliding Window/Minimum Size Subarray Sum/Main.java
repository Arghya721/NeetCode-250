// LeetCode Problem: https://leetcode.com/problems/minimum-size-subarray-sum/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, i = 0, j = 0;
        int minLength = Integer.MAX_VALUE;

        while(j < nums.length){
            sum += nums[j];
            
            while (sum >= target) {
                minLength = Math.min(minLength, j - i + 1);
                sum -= nums[i];
                i++;
            }
            
            j++;
        }

        if(minLength == Integer.MAX_VALUE)
            minLength = 0;

        return minLength;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int result = solution.minSubArrayLen(target, nums);
        System.out.println("Minimum size subarray length: " + result);
    }
}
