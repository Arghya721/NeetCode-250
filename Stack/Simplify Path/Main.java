// LeetCode Problem: https://leetcode.com/problems/simplify-path/

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String ans = "";
        for(int i=0; i<path.length(); i++){
            if(path.charAt(i) == '/'){
                continue;
            }
            String temp = "";
            while(i < path.length() && path.charAt(i) != '/'){
                temp += path.charAt(i);
                i++;
            }
            if(temp.equals("."))
                continue;
            else if(temp.equals("..")){
                if(!st.isEmpty())
                    st.pop();
            } else {
                st.push(temp);
            }
        }

        while(!st.isEmpty()){
            ans = "/" + st.pop() + ans;
        }

        if(ans.equals(""))
            ans = "/";

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String path = "/a/./b/../../c/";
        String result = solution.simplifyPath(path);
        System.out.println("Simplified path: " + result);
    }
}
