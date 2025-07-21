// LeetCode Problem: https://leetcode.com/problems/online-stock-span/

import java.util.Stack;

class StockSpanner {
    class Pair {
        public int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    Stack<Pair> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!st.isEmpty() && st.peek().second <= price) {
            span += st.peek().first;
            st.pop();
        }

        st.push(new Pair(span, price));
        return span;
    }
}

public class Main {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        int[] prices = { 100, 80, 60, 70, 60, 75, 85 };
        for (int price : prices) {
            System.out.print(stockSpanner.next(price) + " ");
        }
    }
}
