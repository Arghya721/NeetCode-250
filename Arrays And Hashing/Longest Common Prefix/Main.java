// leetcode problem: https://leetcode.com/problems/longest-common-prefix/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for(int i=1; i<strs.length; i++){
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix == "")
                    return "";
            }
        }
        return prefix;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"flower", "flow", "flight"};
        String result = solution.longestCommonPrefix(strs);
        System.out.println("Longest Common Prefix: " + result);
    }
}
