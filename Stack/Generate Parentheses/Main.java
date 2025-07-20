// LeetCode Problem: https://leetcode.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;

class Solution {
    private void solve(int open, int close, int n, List<String> ans, String temp){
        if(open == n && close == n){
            ans.add(temp);
            return;
        }

        if(open < n){
            solve(open+1, close, n, ans, temp + "(");
        }

        if(open > close){
            solve(open, close+1, n, ans, temp + ")");
        }

        return;
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(0, 0, n, ans, "");
        return ans;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        List<String> result = solution.generateParenthesis(n);
        System.out.println("Generated Parentheses: " + result);
    }
}
