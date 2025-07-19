// LeetCode Problem: https://leetcode.com/problems/implement-queue-using-stacks/

import java.util.Stack;

class MyQueue {
    Stack<Integer> st;
    public MyQueue() {
        st = new Stack<>();
    }
    
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while(!st.isEmpty()){
            temp.push(st.pop());
        }

        st.push(x);
        while(!temp.isEmpty()){
            st.push(temp.pop());
        }
    }
    
    public int pop() {
        return st.pop();
    }
    
    public int peek() {
        return st.peek();
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}


public class Main {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println("Front element: " + queue.peek());
        System.out.println("Popped element: " + queue.pop());
        System.out.println("Is queue empty? " + queue.empty());
    }
}
