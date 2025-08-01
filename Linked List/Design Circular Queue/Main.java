// LeetCode Problem: https://leetcode.com/problems/design-circular-queue/

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class MyCircularQueue {
    ListNode head, tail;
    int size, count;

    public MyCircularQueue(int k) {
        head = null;
        tail = null;
        size = k;
        count = 0;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        ListNode newNode = new ListNode(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }

        count--;
        return true;
    }

    public int Front() {
        if (head == null)
            return -1;

        return head.val;
    }

    public int Rear() {
        if (tail == null)
            return -1;

        return tail.val;
    }

    public boolean isEmpty() {
        if (count == 0)
            return true;

        return false;
    }

    public boolean isFull() {
        if (count == size)
            return true;

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        System.out.println(circularQueue.enQueue(1)); // return true
        System.out.println(circularQueue.enQueue(2)); // return true
        System.out.println(circularQueue.enQueue(3)); // return true
        System.out.println(circularQueue.enQueue(4)); // return false, the queue is full
        System.out.println(circularQueue.Rear());      // return 3
        System.out.println(circularQueue.isFull());    // return true
        System.out.println(circularQueue.deQueue());   // return true
        System.out.println(circularQueue.enQueue(4));  // return true
        System.out.println(circularQueue.Rear());      // return 4

        System.out.println(circularQueue.Front());     // return 2
        System.out.println(circularQueue.isEmpty());   // return false
    }
}
