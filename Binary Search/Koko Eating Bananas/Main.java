// LeetCode Problem: https://leetcode.com/problems/koko-eating-bananas/

import java.util.Arrays;

class Solution {
    private boolean isPossible(int[] piles, int mid, int h){
        int hoursTaken = 0;
        for(int i=0; i<piles.length; i++){
            hoursTaken += Math.ceil((double)(piles[i])/(double)(mid));
        }

        return hoursTaken <= h ? true : false;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().getAsInt();
        int ans = 0;

        while(low <= high){
            int mid = (low + high)/2;
            boolean possible = isPossible(piles, mid, h);
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
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int result = solution.minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result);
    }
}
