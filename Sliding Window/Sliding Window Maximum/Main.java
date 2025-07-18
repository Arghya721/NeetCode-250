// Leetcode Problem: https://leetcode.com/problems/sliding-window-maximum/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int i=0, j = 0;
        int[] ans = new int[nums.length - k + 1];

        while(j < k){
            while(!dq.isEmpty() && nums[j] >= nums[dq.getLast()]){
                dq.removeLast();
            }

            dq.addLast(j);
            j++;
        }

        while(j < nums.length){
            ans[i++] = nums[dq.getFirst()];
            while(!dq.isEmpty() && j-k >= dq.getFirst())
                dq.removeFirst();
            
            while(!dq.isEmpty() && nums[j] >= nums[dq.getLast()])
                dq.removeLast();
            
            dq.addLast(j);
            j++;
        }
        ans[i++] = nums[dq.getFirst()];
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);
        for (int max : result) {
            System.out.print(max + " ");
        }
    }
}
