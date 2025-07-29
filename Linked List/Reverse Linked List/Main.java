// LeetCode Problem: https://leetcode.com/problems/reverse-linked-list/

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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null;

        while (curr != null) {
            ListNode nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return prev;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reverse the linked list
        Solution solution = new Solution();
        ListNode reversedHead = solution.reverseList(head);

        // Print the reversed linked list
        ListNode curr = reversedHead;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
