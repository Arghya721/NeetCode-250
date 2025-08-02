// LeetCode Problem: https://leetcode.com/problems/lfu-cache/

import java.util.HashMap;

class Node {
    int key, val;
    Node next, prev;
    int count;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.count = 1;
    }
}

class ListNode {
    int size;
    Node head, tail;

    ListNode(){
        head = new Node(0, 0);
        tail = new Node(0, 0);
        size = 0;
        head.next = tail;
        tail.prev = head;
    }

    void addFront(Node node){
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
        size++;
    }

    void deleteNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        size--;
    }

    Node removeLast() {
        if (size > 0) {
            Node last = tail.prev;
            deleteNode(last);
            return last;
        }
        return null;
    }
}

class LFUCache {
    int capacity, currSize, minFreq;
    HashMap<Integer, ListNode> freqMap;
    HashMap<Integer, Node> keyMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        freqMap = new HashMap<>();
        keyMap  = new HashMap<>();
        currSize = 0;
        minFreq = 0;
    }

    void updateFreqListMap(Node node){
        int oldCount = node.count;
        freqMap.get(oldCount).deleteNode(node);

        if(oldCount == minFreq && freqMap.get(oldCount).size == 0){
            minFreq++;
        }

        node.count++;

        freqMap.computeIfAbsent(node.count, _ -> new ListNode());
        freqMap.get(node.count).addFront(node);

        keyMap.put(node.key, node);
    }

    public int get(int key) {
        if(!keyMap.containsKey(key)){
            return -1;
        }
        Node node = keyMap.get(key);
        updateFreqListMap(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(capacity == 0) return;

        if(keyMap.containsKey(key)){
            Node node = keyMap.get(key);
            node.val = value;
            updateFreqListMap(node);
        } else {
            currSize++;
            if(currSize > capacity){
                ListNode minFreqList = freqMap.get(minFreq);
                Node toRemove = minFreqList.removeLast();
                keyMap.remove(toRemove.key);
                currSize--;
            }

            Node newNode = new Node(key, value);
            minFreq = 1;

            freqMap.computeIfAbsent(1, _ -> new ListNode());
            freqMap.get(1).addFront(newNode);

            keyMap.put(key, newNode);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1)); // returns 1
        lfuCache.put(3, 3); // evicts key 2
        System.out.println(lfuCache.get(2)); // returns -1 (not found)
        lfuCache.put(4, 4); // evicts key 1
        System.out.println(lfuCache.get(1)); // returns -1 (not found)
        System.out.println(lfuCache.get(3)); // returns 3
        System.out.println(lfuCache.get(4)); // returns 4
    }
}
