// LeetCode Problem: https://leetcode.com/problems/merge-strings-alternately/

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        String ans = "";

        while(i < word1.length() && j < word2.length()){
            if(i==j)
                ans += word1.charAt(i++);
            else 
                ans += word2.charAt(j++);
        }

        while(i<word1.length()){
            ans += word1.charAt(i++);
        }

        while(j < word2.length()){
            ans += word2.charAt(j++);
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String word1 = "abc";
        String word2 = "pqr";
        System.out.println(solution.mergeAlternately(word1, word2)); // Output: "apbqcr"
    }
}
