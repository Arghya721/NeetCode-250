// LeetCode Problem: https://leetcode.com/problems/minimum-window-substring/

import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) + 1);
        }

        int have = 0, need = t.length(), maxLength = Integer.MAX_VALUE, startIndex = 0, i = 0, j = 0;

        while (j < s.length()) {
            if (count.containsKey(s.charAt(j))) {
                window.put(s.charAt(j), window.getOrDefault(s.charAt(j), 0) + 1);

                if (window.get(s.charAt(j)) <= count.get(s.charAt(j)))
                    have++;
            }

            while (have == need) {
                if (j - i + 1 < maxLength) {
                    maxLength = j - i + 1;
                    startIndex = i;
                }

                if (window.containsKey(s.charAt(i))) {
                    window.put(s.charAt(i), window.getOrDefault(s.charAt(i), 0) - 1);

                    if (window.get(s.charAt(i)) < count.get(s.charAt(i)))
                        have--;
                }
                i++;
            }
            j++;
        }
        return maxLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + maxLength);
    }
}



public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = solution.minWindow(s, t);
        System.out.println("Minimum window substring: " + result);
    }
}