// LeetCode Problem: https://leetcode.com/problems/merge-sorted-array/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int itr1 = m-1, itr2 = n-1, itr1end = nums1.length-1;
        while(itr1 >= 0 && itr2 >= 0){
            if(nums1[itr1] <= nums2[itr2]){
                nums1[itr1end--] = nums2[itr2--];
            } else {
                nums1[itr1end--] = nums1[itr1--];
            }
        }

        while(itr2 >= 0){
            nums1[itr1end--] = nums2[itr2--];
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}
