// LeetCode Problem: https://leetcode.com/problems/evaluate-reverse-polish-notation/

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String op : tokens) {
            switch (op) {
                case "+": {
                    int first = st.pop();
                    int second = st.pop();
                    st.push(second + first);
                    break;
                }
                case "-": {
                    int first = st.pop();
                    int second = st.pop();
                    st.push(second - first);
                    break;
                }
                case "*": {
                    int first = st.pop();
                    int second = st.pop();
                    st.push(second * first);
                    break;
                }
                case "/": {
                    int first = st.pop();
                    int second = st.pop();
                    st.push(second / first);
                    break;
                }
                default:
                    st.push(Integer.parseInt(op));
            }
        }
        return st.peek();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] tokens = {"2", "1", "+", "3", "*"};
        int result = solution.evalRPN(tokens);
        System.out.println("Result: " + result);
    }
}
