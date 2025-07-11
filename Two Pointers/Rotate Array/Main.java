// LeetCode Problem: https://leetcode.com/problems/rotate-array/

import java.util.Arrays;

class Solution {
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k % (nums.length);
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
