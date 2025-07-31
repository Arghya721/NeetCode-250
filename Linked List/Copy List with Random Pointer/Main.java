// LeetCode Problem: https://leetcode.com/problems/copy-list-with-random-pointer/

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        
        Node temp = head;
        while(temp!= null){
            Node nex = temp.next;
            Node newNode = new Node(temp.val);
            temp.next = newNode;
            newNode.next = nex;
            temp = nex;
        }

        temp = head;
        while(temp != null){
            if(temp.next != null){
                temp.next.random = temp.random != null ? temp.random.next : null;
                temp = temp.next.next;
            }
        }

        temp = head;
        Node copy = temp.next;
        Node copyPtr = copy;

        while(temp != null){
            temp.next = temp.next.next;
            copyPtr.next = copyPtr.next != null ? copyPtr.next.next : null;
            temp = temp.next;
            copyPtr = copyPtr.next;
        }

        return copy;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a linked list with random pointers
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Set random pointers
        head.random = head.next.next; // 1 -> 3
        head.next.random = head;       // 2 -> 1
        head.next.next.random = head.next.next.next; // 3 -> 4
        head.next.next.next.random = head.next; // 4 -> 2
        head.next.next.next.next.random = head.next.next; // 5 -> 3

        // Copy the list
        Solution solution = new Solution();
        Node copiedList = solution.copyRandomList(head);

        // Print the original and copied list
        printList(head);
        printList(copiedList);
    }

    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print("Value: " + curr.val);
            if (curr.random != null) {
                System.out.print(", Random: " + curr.random.val);
            }
            System.out.println();
            curr = curr.next;
        }
    }
}
