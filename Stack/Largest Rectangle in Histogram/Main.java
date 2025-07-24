// LeetCode Problem: https://leetcode.com/problems/largest-rectangle-in-histogram/

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int[] prevLess = new int[heights.length];
        int[] nextLess = new int[heights.length];

        for(int i=0; i<heights.length; i++){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()])
                st.pop();
            
            prevLess[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for(int i=heights.length-1; i>=0; i--){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()])
                st.pop();
            
            nextLess[i] = st.isEmpty() ? heights.length : st.peek();
            st.push(i);
        }

        int maxArea = 0;
        for(int i=0; i<heights.length; i++){
            int width = nextLess[i] - prevLess[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(heights)); // 10
    }
}
