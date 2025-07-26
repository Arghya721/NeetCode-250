// LeetCode Problem: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

import java.util.Arrays;

class Solution {
    private boolean isPossible(int[] weights, int mid, int days){
        int daysTaken = 1;
        int tempWeight = 0;
        for(int i=0; i<weights.length; i++){
            tempWeight += weights[i];
            if(tempWeight > mid){
                daysTaken++;
                tempWeight = weights[i];
            }
        }
        return daysTaken <= days ? true : false;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt(), high = Arrays.stream(weights).sum();
        int ans = 0;

        while(low <= high){
            int mid = (low + high)/2;
            boolean possible = isPossible(weights, mid, days);
            if(possible){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] weights = {1, 2, 3, 4, 5};
        int days = 2;
        int result = solution.shipWithinDays(weights, days);
        System.out.println("Minimum capacity to ship within " + days + " days: " + result);
    }
}
