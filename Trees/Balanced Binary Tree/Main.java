// LeetCode Problem: https://leetcode.com/problems/balanced-binary-tree/description/

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
    int checkBalanced(TreeNode root){
        if(root == null)
            return 0;
        
        int left = checkBalanced(root.left);
        int right = checkBalanced(root.right);

        if(left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;
        
        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        return checkBalanced(root) == -1 ? false : true;
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

        // Check if the binary tree is balanced
        boolean isBalanced = solution.isBalanced(root);

        // Print the result
        System.out.println("Is the binary tree balanced? " + isBalanced);
    }
}
