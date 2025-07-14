// LeetCode Problem: https://leetcode.com/problems/permutation-in-string/

import java.util.HashMap;
import java.util.Map;

class Solution {
    private boolean allZeros(HashMap<Character, Integer> mp){
        for(Map.Entry<Character, Integer> entry : mp.entrySet()){
            if(entry.getValue() != 0)
                return false;
        }

        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            mp.put(s1.charAt(i), mp.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int i = 0, j = 0;
        while(j < s2.length()){
            if(mp.containsKey(s2.charAt(j))){
                mp.put(s2.charAt(j), mp.getOrDefault(s2.charAt(j), 0) - 1);
            }

            while(j-i+1 > s1.length()){
                if(mp.containsKey(s2.charAt(i)))
                    mp.put(s2.charAt(i), mp.getOrDefault(s2.charAt(i), 0) + 1);
                i++;
            }

            if(allZeros(mp))
                return true;
            
            j++;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean result = solution.checkInclusion(s1, s2);
        System.out.println("Result: " + result);
    }
}
