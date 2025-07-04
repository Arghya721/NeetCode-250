// LeetCode Problem: https://leetcode.com/problems/sort-an-array/
import java.util.Arrays;

class Solution {
    private void merge(int[] nums, int left, int mid, int right){
        int i = left;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[right-left + 1];

        while(i <= mid && j <= right){
            if(nums[i] < nums[j]){
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while(i <= mid){
            temp[k++] = nums[i++];
        }

        while(j <= right){
            temp[k++] = nums[j++];
        }

        for(int idx = 0; idx < k; idx++){
            nums[left + idx] = temp[idx];
        }
    }

    private void mergeSort(int[] nums, int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid+1, right);
            merge(nums, left, mid, right);
        }
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 2, 3, 1, 4};
        int[] sortedArray = solution.sortArray(nums);
        System.out.println(Arrays.toString(sortedArray));
    }
}
