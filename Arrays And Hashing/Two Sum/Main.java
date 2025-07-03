// leetcode problem: https://leetcode.com/problems/two-sum/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(mp.containsKey(target - nums[i])){
                return new int[]{mp.get(target-nums[i]), i};
            }
            mp.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println("Indices of the two numbers that add up to " + target + ": [" + result[0] + ", " + result[1] + "]");
    }
}
