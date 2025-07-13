// LeetCode Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestSubstring = 0, i = 0, j = 0;
        HashMap<Character, Integer> mp = new HashMap<>();

        while(j < s.length()){
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);

            while(mp.get(s.charAt(j)) > 1){
                mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) - 1);
                i++;
            }
            
            longestSubstring = Math.max(longestSubstring, j-i+1);
            j++;
        }
        return longestSubstring;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcabcbb";
        int length = solution.lengthOfLongestSubstring(s);
        System.out.println("Length of longest substring without repeating characters: " + length);
    }
}
