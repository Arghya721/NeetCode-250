// LeetCode Problem: https://leetcode.com/problems/decode-string/

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<String> strSt = new Stack<>();
        int num = 0;
        String ans = "";
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10  + (ch-'0');
            } else if (ch == '[') {
                numSt.push(num);
                num = 0;
                strSt.push(ans);
                ans = "";
            } else if (ch == ']'){
                int rep = numSt.pop();
                String top = strSt.pop();

                while(rep-- > 0){
                    top += ans;
                }
                ans = top;
            } else {
                ans += ch;
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "3[a2[c]]";
        String decodedString = solution.decodeString(s);
        System.out.println(decodedString);  // Output: "accaccacc"
    }
}
