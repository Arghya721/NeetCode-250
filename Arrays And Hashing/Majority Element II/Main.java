// Leetcode Problem: https://leetcode.com/problems/majority-element-ii/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE, count1 = 0, count2 = 0;

        for(int i=0; i<nums.length; i++){
            if(element1 == nums[i]){
                count1++;
            } else if (element2 == nums[i]){
                count2++;
            } else if (count1 == 0){
                element1 = nums[i];
                count1++;
            } else if(count2 == 0){
                element2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == element1)
                count1++;
            if(nums[i] == element2)
                count2++;
        }

        List<Integer> ans = new ArrayList<>();

        if(count1 > nums.length/3)
            ans.add(element1);
        
        if(count2 > nums.length/3)
            ans.add(element2);
        
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 3};
        List<Integer> result = solution.majorityElement(nums);
        System.out.println(result); // Output: [3]
    }
}
