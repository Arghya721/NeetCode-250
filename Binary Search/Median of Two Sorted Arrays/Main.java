// LeetCode Problem: https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(m > n)
            return findMedianSortedArrays(nums2, nums1);
        
        int low = 0, high = m, median = (m+n+1)/2;

        while(low <= high){
            int mid1 = (low + high)/2;
            int mid2 = median - mid1;

            int l1 = mid1 - 1 >= 0 ? nums1[mid1-1] : Integer.MIN_VALUE;
            int l2 = mid2 - 1 >=0 ? nums2[mid2-1] : Integer.MIN_VALUE;
            int r1 = mid1 < m ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < n ? nums2[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1) {
                if((m+n)%2 != 0){
                    return (double)Math.max(l1,l2);
                } else {
                    return (double) (Math.max(l1,l2) + Math.min(r1, r2)) / 2.0;
                }
            }

            if(l1 > r2){
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return -1;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // Output: 2.0

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println(solution.findMedianSortedArrays(nums3, nums4)); // Output: 2.5
    }
}
