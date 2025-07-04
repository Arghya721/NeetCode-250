// LeetCode Problem: https://leetcode.com/problems/design-hashmap/

import java.util.Arrays;

class MyHashMap {
    int[] hashMap;
    public MyHashMap() {
        hashMap = new int[1000001];
        Arrays.fill(hashMap, -1);
    }
    
    public void put(int key, int value) {
        hashMap[key] = value;
    }
    
    public int get(int key) {
        return hashMap[key];
    }
    
    public void remove(int key) {
        hashMap[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

public class Main {
    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1)); // 1
        System.out.println(obj.get(3)); // -1
        obj.put(2, 1);
        System.out.println(obj.get(2)); // 1
        obj.remove(2);
        System.out.println(obj.get(2)); // -1
    }
}
