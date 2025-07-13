// LeetCode Problem: https://leetcode.com/problems/longest-repeating-character-replacement/

import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int maxFreq = 0, i = 0, j = 0, maxLength = 0;

        while(j < s.length()){
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
            maxFreq = Math.max(maxFreq, mp.get(s.charAt(j)));

            while(j-i+1 - maxFreq > k){
                mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) - 1);
                i++;
            }

            maxLength = Math.max(maxLength, j-i+1);
            j++;
        }

        return maxLength;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "AABABBA";
        int k = 1;
        int length = solution.characterReplacement(s, k);
        System.out.println("Length of longest substring with repeating character replacement: " + length);
    }
}
