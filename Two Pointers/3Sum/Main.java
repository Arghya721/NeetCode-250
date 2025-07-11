// LeetCode Problem: https://leetcode.com/problems/3sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            
            int j = i+1;
            int k = nums.length - 1;

            while(j < k){
                long sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while(j < k && nums[k] == nums[k+1])
                        k--;
                    while(j < k && nums[j] == nums[j-1])
                        j++;
                } else if (sum > 0){
                    k--;
                } else {
                   j++;
                }
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result);
    }
}
