// LeetCode Problem: https://leetcode.com/problems/invert-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

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
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        
        TreeNode temp = new TreeNode(root.val);

        temp.left = invertTree(root.right);
        temp.right = invertTree(root.left);

        return temp;
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

        // Invert the binary tree
        TreeNode invertedRoot = solution.invertTree(root);

        // Print the tree structure
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(invertedRoot);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
}
