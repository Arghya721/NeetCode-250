// LeetCode Problem: https://leetcode.com/problems/subtree-of-another-tree/

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
    private boolean isSameTree(TreeNode tree1, TreeNode tree2){
        if(tree1 == null && tree2 == null)
            return true;
        
        if(tree1 == null || tree2 == null)
            return false;
        
        if(tree1.val == tree2.val)
            return isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
        
        return false;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;
        
        if(isSameTree(root, subRoot))
            return true;
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}

public class Main {
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(0);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        Solution solution = new Solution();
        boolean result = solution.isSubtree(root, subRoot);
        System.out.println("Is subRoot a subtree of root? " + result);
    }
}
