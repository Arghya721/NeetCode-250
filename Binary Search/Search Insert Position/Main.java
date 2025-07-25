// LeetCode Problem: https://leetcode.com/problems/search-insert-position/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int result = solution.searchInsert(nums, target);
        System.out.println("Insert position of target " + target + ": " + result);
    }
}
