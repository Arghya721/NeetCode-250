// LeetCode Problem: https://leetcode.com/problems/valid-parentheses/

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if ((!st.isEmpty() && ch == ')' && st.peek() == '(') ||  (!st.isEmpty() && ch == ']' && st.peek() == '[')  || (!st.isEmpty() && ch == '}' && st.peek() == '{')){
                st.pop();
            } else {
                st.push(ch);
            }
        }

        return st.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()[]{}";
        boolean result = solution.isValid(s);
        System.out.println("Is Valid Parentheses: " + result);
    }
}
