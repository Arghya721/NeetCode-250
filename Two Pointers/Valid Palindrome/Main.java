// LeetCode Problem: https://leetcode.com/problems/valid-palindrome/

class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) == ' ' || !Character.isLetterOrDigit(s.charAt(start)))
                start++;
            else if (s.charAt(end) == ' ' || !Character.isLetterOrDigit(s.charAt(end)))
                end--;
            else if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
                return false;
            else {
                start++;
                end--;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(solution.isPalindrome(s)); // Output: true
    }
}
