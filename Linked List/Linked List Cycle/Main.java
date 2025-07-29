// LeetCode Problem: https://leetcode.com/problems/linked-list-cycle/

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

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }
        
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a linked list: 3 -> 2 -> 0 -> -4
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        // Create a cycle for testing: -4 -> 2
        head.next.next.next.next = head.next;

        // Check if the linked list has a cycle
        Solution solution = new Solution();
        boolean hasCycle = solution.hasCycle(head);
        System.out.println("Has cycle: " + hasCycle);
    }
}
