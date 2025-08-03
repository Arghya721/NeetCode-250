// LeetCode Problem: https://leetcode.com/problems/maximum-depth-of-binary-tree/


class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);

        return Math.max(left, right);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Create a Solution object
        Solution solution = new Solution();

        // Get the maximum depth
        int maxDepth = solution.maxDepth(root);

        // Print the result
        System.out.println("Maximum depth of the binary tree: " + maxDepth);
    }
}
