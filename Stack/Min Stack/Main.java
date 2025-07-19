// LeetCode Problem: https://leetcode.com/problems/min-stack/

import java.util.Stack;

class MinStack {
    Stack<Integer> st;
    Stack<Integer> minStack;
    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(val);
            minStack.push(val);
            return;
        }
        st.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }
    
    public void pop() {
        st.pop();
        minStack.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Minimum element: " + minStack.getMin());
        minStack.pop();
        System.out.println("Top element: " + minStack.top());
        System.out.println("Minimum element: " + minStack.getMin());
    }
}
