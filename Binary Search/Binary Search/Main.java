// LeetCode Problem: https://leetcode.com/problems/binary-search/

class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int result = solution.search(nums, target);
        System.out.println("Index of target " + target + ": " + result);
    }
}
