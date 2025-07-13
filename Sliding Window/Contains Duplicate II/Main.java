// LeetCode Problem: https://leetcode.com/problems/contains-duplicate-ii/

import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int i = 0, j = 0;
        while(j < nums.length){
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

            while(j-i > k){
                mp.put(nums[i], mp.getOrDefault(nums[i], 0) - 1);
                i++;
            }

            if(mp.get(nums[j]) > 1)
                return true;
            
            j++;
        }
        return false;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        boolean hasDuplicate = solution.containsNearbyDuplicate(nums, k);
        System.out.println("Contains nearby duplicate: " + hasDuplicate);
    }
}
