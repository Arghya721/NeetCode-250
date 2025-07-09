// Leetcode Problem: https://leetcode.com/problems/subarray-sum-equals-k/

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int count = 0, sum = 0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(sum == k)
                count++;

            if(mp.containsKey(sum-k)){
                count += mp.get(sum-k);
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(solution.subarraySum(nums, k)); // Output: 2
    }
}
