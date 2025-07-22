// LeetCode Problem: https://leetcode.com/problems/car-fleet/

import java.util.Arrays;
import java.util.Stack;

class Solution {
    class Pair {
        public int first, second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> st = new Stack<>();
        Pair[] carSpeed = new Pair[position.length];
        for(int i =0; i<position.length; i++){
            carSpeed[i] = new Pair(position[i], speed[i]);
        }

        Arrays.sort(carSpeed, (a, b) -> b.first - a.first);

        for(int i=0; i<carSpeed.length; i++){
            double time = (double)(target - carSpeed[i].first) / (double) (carSpeed[i].second);
            if(!st.isEmpty() && time <= st.peek())
                continue;
            
            st.push(time);
        }

        return st.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        int result = solution.carFleet(target, position, speed);
        System.out.println("Number of car fleets: " + result);
    }
}
