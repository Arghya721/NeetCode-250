// LeetCode Problem: https://leetcode.com/problems/sqrtx/

class Solution {
    public int mySqrt(int x) {
        long low = 0, high = x, ans = 0;

        while(low <= high){
            long mid = (low + high)/2;
            if(mid * mid <= x){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int)(ans);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.mySqrt(8);
        System.out.println("Square root: " + result);
    }
}
