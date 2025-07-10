// LeetCode Problem: https://leetcode.com/problems/valid-palindrome-ii/

class Solution {
    private boolean isValid(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int start = 0, end = s.length()-1;
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            } else {
                return isValid(s, start+1, end) || isValid(s, start, end - 1);
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abca";
        System.out.println(solution.validPalindrome(s)); // Output: true
    }
}
