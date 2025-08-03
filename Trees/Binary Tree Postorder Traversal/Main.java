// LeetCode Problem: https://leetcode.com/problems/binary-tree-postorder-traversal/


import java.util.ArrayList;
import java.util.LinkedList;
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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new LinkedList<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            ans.add(0, temp.val);

            if(temp.left != null)
                st.push(temp.left);
            if(temp.right != null)
                st.push(temp.right);
        }
        return ans;
    }
}


public class Main {
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // Create a Solution object
        Solution solution = new Solution();

        // Get the postorder traversal
        List<Integer> result = solution.postorderTraversal(root);

        // Print the result
        System.out.println(result);
    }
}
