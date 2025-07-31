// LeetCode Problem: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
    private int countNodes(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }

        return count;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = countNodes(head);
        int nthNode = count - n;
        if(nthNode == 0)
            return head.next;
        
        ListNode curr = head;
        while(nthNode > 1){
            curr = curr.next;
            nthNode--;
        }

        ListNode nex = curr.next.next;
        curr.next = nex;

        return head;
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

        // Remove the 2nd node from the end
        Solution solution = new Solution();
        head = solution.removeNthFromEnd(head, 2);

        // Print the modified linked list
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
