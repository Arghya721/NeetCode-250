// leetcode problem: https://leetcode.com/problems/group-anagrams/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> mp = new HashMap<>();

        for(int i=0; i<strs.length; i++) {
            String temp = strs[i];
            char[] chars = temp.toCharArray();
            Arrays.sort(chars);
            temp = new String(chars);
            mp.computeIfAbsent(temp, _ -> new ArrayList<>()).add(strs[i]);
        }

        for(Map.Entry<String, List<String>> entry : mp.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println("Grouped Anagrams: " + result);
    }
}
