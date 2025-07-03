// leetcode problem: https://leetcode.com/problems/valid-anagram/

import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i=0; i< t.length(); i++){
            if(mp.containsKey(t.charAt(i))){
                mp.put(t.charAt(i), mp.get(t.charAt(i)) - 1);
                if(mp.get(t.charAt(i)) == 0)
                    mp.remove(t.charAt(i));
            }
        }

        return mp.isEmpty();
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "anagram";
        String t = "nagaram";
        boolean result = solution.isAnagram(s, t);
        System.out.println("Is \"" + s + "\" an anagram of \"" + t + "\": " + result);
    }
}
