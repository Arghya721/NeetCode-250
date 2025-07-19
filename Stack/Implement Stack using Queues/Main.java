// LeetCode Problem: https://leetcode.com/problems/implement-stack-using-queues/

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> qt;
    public MyStack() {
        qt = new LinkedList<>();
    }
    
    public void push(int x) {
        Queue<Integer> temp = new LinkedList<>();
        while(!qt.isEmpty()){
            temp.add(qt.poll());
        }
        qt.add(x);
        while(!temp.isEmpty()){
            qt.add(temp.poll());
        }
    }
    
    public int pop() {
        return qt.poll();
    }
    
    public int top() {
        return qt.peek();
    }
    
    public boolean empty() {
        return qt.isEmpty();
    }
}


public class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Is stack empty? " + stack.empty());
    }
}
