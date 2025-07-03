// https://leetcode.com/problems/contains-duplicate/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(mp.containsKey(nums[i]))
                return true;
            mp.put(nums[i], 1);
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 1};
        boolean result = solution.containsDuplicate(nums);
        System.out.println(result);
    }
}