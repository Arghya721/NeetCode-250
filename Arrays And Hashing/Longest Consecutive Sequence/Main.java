// Leetcode Problem: https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            st.add(nums[i]);
        }
        int ans = 0;
        for(Integer i : st){
            if(!st.contains(i - 1)){
                int count = 0;
                int x = i;
                while(st.contains(x)){
                    count++;
                    x++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums)); // Output: 4
    }
}
