// LeetCode Problem: https://leetcode.com/problems/container-with-most-water/

class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int ans = 0;
        while(i < j){
            if(height[i] < height[j]){
                ans = Math.max(ans, (j-i)*height[i]);
                i++;
            } else {
                ans = Math.max(ans, (j-i)*height[j]);
                j--;
            }
        }
        return ans;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = solution.maxArea(height);
        System.out.println("Max area: " + maxArea);
    }
}
