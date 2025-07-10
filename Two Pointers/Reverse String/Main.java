// LeetCode Problem: https://leetcode.com/problems/reverse-string/

class Solution {
    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s);
        System.out.println(s); // Output: ['o', 'l', 'l', 'e', 'h']
    }
}
