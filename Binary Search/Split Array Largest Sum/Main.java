// LeetCode Problem: https://leetcode.com/problems/split-array-largest-sum/

import java.util.Arrays;

class Solution {
    int calculateSplitsPossible(int[] nums, int mid){
        int splits = 1, sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum > mid){
                splits++;
                sum = nums[i];
            }
        }
        return splits;
    }


    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt(), high = Arrays.stream(nums).sum(), ans = 0;

        while(low <= high){
            int mid = (low + high)/2;
            int splits = calculateSplitsPossible(nums, mid);
            if(splits > k){
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        int result = solution.splitArray(nums, k);
        System.out.println(result);  // Output: 18
    }
}
