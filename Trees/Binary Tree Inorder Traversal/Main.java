// LeetCode Problem: https://leetcode.com/problems/binary-tree-inorder-traversal/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode temp = root;
        Stack<TreeNode> st = new Stack<>();
        while(true){
            if(temp != null){
                st.push(temp);
                temp = temp.left;
            } else {
                if(st.isEmpty())
                    break;
                
                temp = st.pop();
                ans.add(temp.val);
                temp = temp.right;
            }
        }

        return ans;
    }
}


public class Main {
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        // Create a Solution object
        Solution solution = new Solution();

        // Get the inorder traversal
        List<Integer> result = solution.inorderTraversal(root);

        // Print the result
        System.out.println(result);
    }
}
