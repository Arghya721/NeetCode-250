// LeetCode Problem: https://leetcode.com/problems/asteroid-collision/

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int asteroid : asteroids){
            int currAst = asteroid;
            while(!st.isEmpty() && currAst < 0 && st.peek() > 0){
                if(Math.abs(currAst) > st.peek()){
                    st.pop();
                } else if (Math.abs(currAst) == st.peek()){
                    st.pop();
                    currAst = 0;
                } else {
                    currAst = 0;
                }
            }
            if(currAst != 0)
                st.push(currAst);
        }
        int[] ans = new int[st.size()];
        int i = st.size() - 1;
        while(!st.isEmpty()){
            ans[i--] = st.pop();
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] asteroids = {5, 10, -5};
        int[] result = solution.asteroidCollision(asteroids);
        System.out.println("Resulting Asteroids: " + Arrays.toString(result));
    }
}
