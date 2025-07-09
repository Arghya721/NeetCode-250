// LeetCode Problem: https://leetcode.com/problems/first-missing-positive/

import java.util.HashSet;

class Solution {

    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++){
            st.add(nums[i]);
        }

        int missingNumber = 1;
        for (Integer _ : st){
            if (st.contains(missingNumber)){
                missingNumber++;
            }
        }

        return missingNumber;
    }

}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 4, -1, 1};
        System.out.println(solution.firstMissingPositive(nums)); // Output: 2
    }
}