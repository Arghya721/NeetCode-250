// LeetCode Problem: https://leetcode.com/problems/design-hashset/

class MyHashSet {
    int[] hashMap;
    public MyHashSet() {
        hashMap = new int[1000001];
    }
    
    public void add(int key) {
        hashMap[key] = 1;
    }
    
    public void remove(int key) {
        hashMap[key] = 0;
    }
    
    public boolean contains(int key) {
        return hashMap[key] > 0 ? true : false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

public class Main {
    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.add(2);
        System.out.println(obj.contains(1)); // true
        System.out.println(obj.contains(3)); // false
        obj.add(2);
        System.out.println(obj.contains(2)); // true
        obj.remove(2);
        System.out.println(obj.contains(2)); // false
    }
}
