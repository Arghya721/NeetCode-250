// LeetCode Problem: https://leetcode.com/problems/time-based-key-value-store/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TimeMap {
    class Pair{
        String first;
        int second;

        public Pair(String first, int second){
            this.first = first;
            this.second = second;
        }
    }
    HashMap<String, List<Pair>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(mp.containsKey(key)){
            mp.get(key).add(new Pair(value, timestamp));
        } else {
            List<Pair> list = new ArrayList<>();
            list.add(new Pair(value, timestamp));
            mp.put(key, list);
        }
    }
    
    public String get(String key, int timestamp) {
        if(mp.containsKey(key)){
            List<Pair> matches = mp.get(key);
            int low = 0, high = matches.size() - 1;
            String ans = "";
            while(low <= high){
                int mid = (low + high) / 2;
                if(timestamp >= matches.get(mid).second){
                    ans = matches.get(mid).first;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return ans;
        }
        return "";
    }
}


public class Main {
    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("foo", "bar", 1);
        String param_2 = obj.get("foo", 1);
        System.out.println(param_2);  // Output: bar
    }
}
