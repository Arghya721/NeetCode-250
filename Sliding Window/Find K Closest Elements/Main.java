// LeetCode Problem: https://leetcode.com/problems/find-k-closest-elements/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int left = 0, right = arr.length-1;

        while(right-left >= k){
            if(Math.abs(arr[left]-x) <= Math.abs(arr[right]-x)){
                right--;
            } else {
                left++;
            }
        }

        for(int i = left; i <= right; i++){
            ans.add(arr[i]);
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> result = solution.findClosestElements(arr, k, x);
        System.out.println(result);
    }
}
