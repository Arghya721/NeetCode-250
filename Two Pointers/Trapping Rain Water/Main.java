// LeetCode Problem: https://leetcode.com/problems/trapping-rain-water/

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, ans = 0, lMax = Integer.MIN_VALUE, rMax = Integer.MIN_VALUE;
        
        while(left < right){
            if(height[left] <= height[right]){
                if(lMax < height[left])
                    lMax = height[left];
                else 
                    ans += lMax - height[left];
                left++;
            } else {
                if(rMax < height[right])
                    rMax = height[right];
                else 
                    ans += rMax - height[right];
                right--;
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trappedWater = solution.trap(height);
        System.out.println("Trapped rain water: " + trappedWater);
    }
}
