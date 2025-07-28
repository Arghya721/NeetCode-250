// LeetCode Problem: https://leetcode.com/problems/find-in-mountain-array/

interface MountainArray {
    public int get(int index);
    public int length();
}

class MountainArrayImpl implements MountainArray {
    private int[] arr;

    public MountainArrayImpl(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        return arr[index];
    }

    public int length() {
        return arr.length;
    }
}

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        if (mountainArr.length() == 3) {
            if (mountainArr.get(0) == target) return 0;
            if (mountainArr.get(1) == target) return 1;
            if (mountainArr.get(2) == target) return 2;
        }

        int low = 1, high = mountainArr.length() - 2;

        // find peak
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        int peak = low;

        // binary search on the left half (increasing)
        int leftLow = 0, leftHigh = peak;
        while (leftLow <= leftHigh) {
            int mid = (leftLow + leftHigh) / 2;

            if (target == mountainArr.get(mid)) {
                return mid;
            }

            if (target < mountainArr.get(mid)) {
                leftHigh = mid - 1;
            } else {
                leftLow = mid + 1;
            }
        }

        // binary search on the right half (decreasing)
        int rightLow = peak + 1, rightHigh = mountainArr.length() - 1;
        while (rightLow <= rightHigh) {
            int mid = (rightLow + rightHigh) / 2;

            if (target == mountainArr.get(mid)) {
                return mid;
            }

            if (target < mountainArr.get(mid)) {
                rightLow = mid + 1;
            } else {
                rightHigh = mid - 1;
            }
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] mountain = {1, 3, 5, 7, 6, 4, 2};

        MountainArray mountainArr = new MountainArrayImpl(mountain);

        int target = 6;

        Solution solution = new Solution();
        int index = solution.findInMountainArray(target, mountainArr);

        System.out.println("Target " + target + " found at index: " + index);
    }
}

