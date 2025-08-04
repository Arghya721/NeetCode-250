// LeetCode Problem: https://leetcode.com/problems/same-tree/description/

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        
        if((p == null && q != null) || (p != null && q == null))
            return false;
        
        if(p.val != q.val)
            return false;
        
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);

        return (left && right);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create two sample binary trees
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        // Create a Solution object
        Solution solution = new Solution();

        // Check if the two binary trees are the same
        boolean result = solution.isSameTree(p, q);

        // Print the result
        System.out.println("Are the two binary trees the same? " + result);
    }
}
