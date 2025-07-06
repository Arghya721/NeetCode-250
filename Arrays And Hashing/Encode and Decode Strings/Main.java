// LeetCode Problem: https://leetcode.com/problems/encode-and-decode-strings/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String encode(String s[]) {
        String encodedString = "";
        for(String i : s){
            encodedString += Integer.toString(i.length()) + "#" + i;
        }
        
        return encodedString;
    }

    public String[] decode(String s) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while(i < s.length()){
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
    
            int sizeOfString = Integer.parseInt(s.substring(i, j));        
            String word = s.substring(j+1, j+1+sizeOfString);
            ans.add(word);
            i = j+1+sizeOfString;
        }
        
        return ans.toArray(new String[0]);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = {"Hello", "World"};
        
        String encoded = solution.encode(strings);
        System.out.println("Encoded: " + encoded);
        
        String[] decoded = solution.decode(encoded);
        System.out.print("Decoded: ");
        for (String str : decoded) {
            System.out.print(str + " ");
        }
    }
}
