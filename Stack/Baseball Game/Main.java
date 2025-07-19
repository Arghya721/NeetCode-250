// LeetCode Problem: https://leetcode.com/problems/baseball-game/

import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for (String op : operations) {
            switch (op) {
                case "+":
                    int first = st.pop();
                    int second = st.pop();
                    st.push(second);
                    st.push(first);
                    st.push(first + second);
                    break;
                case "D":
                    st.push(st.peek() * 2);
                    break;
                case "C":
                    st.pop();
                    break;
                default:
                    st.push(Integer.parseInt(op));
                    break;
            }
        }

        int sum = 0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }

        return sum;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] operations = {"5", "2", "C", "D", "+"};
        int result = solution.calPoints(operations);
        System.out.println("Total Points: " + result);
    }
}
