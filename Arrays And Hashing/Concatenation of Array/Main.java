// leetcode problem: https://leetcode.com/problems/concatenation-of-array/

class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];

        for(int i=0; i< 2*nums.length; i++){
            ans[i] = nums[i%nums.length];
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 1};
        int[] result = solution.getConcatenation(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
