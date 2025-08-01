// LeetCode Problem: https://leetcode.com/problems/lru-cache/
import java.util.HashMap;

class Node {
    int key, value;
    Node prev, next;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}


class LRUCache {
    Node head, tail;
    HashMap<Integer, Node> mp;
    int size;

    private void addNode(Node newNode){
        Node nex = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = nex;
        nex.prev = newNode;
    }

    private void deleteNode(Node node){
        Node prev = node.prev;
        Node nex = node.next;
        prev.next = node.next;
        nex.prev = prev;
    }


    public LRUCache(int capacity) {
        size = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        mp = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            deleteNode(node);
            addNode(node);
            return node.value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            deleteNode(node);
            node.value = value;
            addNode(node);
            return;
        }

        if(size == mp.size()){
            Node temp = tail.prev;
            tail.prev = temp.prev;
            deleteNode(temp);
            mp.remove(temp.key);
        }

        Node newNode = new Node(key, value);
        addNode(newNode);
        mp.put(key, newNode);
    }
}

public class Main {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1)); // return 1
        lruCache.put(3, 3); // evicts key 2
        System.out.println(lruCache.get(2)); // return -1 (not found)
        lruCache.put(4, 4); // evicts key 1
        System.out.println(lruCache.get(1)); // return -1 (not found)
        System.out.println(lruCache.get(3)); // return 3
        System.out.println(lruCache.get(4)); // return 4
    }
}
