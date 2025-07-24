// LeetCode Problem: https://leetcode.com/problems/maximum-frequency-stack/

import java.util.HashMap;
import java.util.Stack;

class FreqStack {
    HashMap<Integer, Integer> freq;
    HashMap<Integer, Stack<Integer>> mpSt;
    int maxFreq;
    public FreqStack() {
        freq  = new HashMap<>();
        mpSt  = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        maxFreq = Math.max(maxFreq, f);
        if(!mpSt.containsKey(f))
            mpSt.put(f, new Stack<Integer>());
        
        mpSt.get(freq.get(val)).push(val);
    }
    
    public int pop() {
        int x = mpSt.get(maxFreq).pop();
        freq.put(x, maxFreq-1);
        if(mpSt.get(maxFreq).size() == 0)
            maxFreq--;
        
        return x;
    }
}

public class Main {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop()); // 5
        System.out.println(freqStack.pop()); // 7
        System.out.println(freqStack.pop()); // 5
        System.out.println(freqStack.pop()); // 4
    }
}
