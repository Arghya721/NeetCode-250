// LeetCode Problem: https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0], voteCount = 1;

        for(int i=1; i<nums.length; i++){
            if(candidate == nums[i]){
                voteCount++;
            } else {
                voteCount--;
                if(voteCount == 0){
                    candidate = nums[i];
                    voteCount = 1;
                }
            }
        }
        return candidate;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 3};
        int majorityElement = solution.majorityElement(nums);
        System.out.println("Majority Element: " + majorityElement);
    }
}
