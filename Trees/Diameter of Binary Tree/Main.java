// LeetCode Problem: https://leetcode.com/problems/diameter-of-binary-tree/

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
    int height(TreeNode root){
        if(root == null)
            return 0;
        
        int left = 1 + height(root.left);
        int right = 1 + height(root.right);

        return Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
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

        // Get the diameter of the binary tree
        int diameter = solution.diameterOfBinaryTree(root);

        // Print the result
        System.out.println("Diameter of the binary tree: " + diameter);
    }
}
