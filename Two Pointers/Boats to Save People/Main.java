// LeetCode Problem: https://leetcode.com/problems/boats-to-save-people/

import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1, ans = 0;
        while(i <= j){
            if(people[i] + people[j] <= limit){
                ans++;
                i++;
                j--;
            } else {
                ans++;
                j--;
            }
        }
        return ans;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] people = {1, 2, 3, 4, 5};
        int limit = 5;
        int numBoats = solution.numRescueBoats(people, limit);
        System.out.println("Number of boats needed: " + numBoats);
    }
}
