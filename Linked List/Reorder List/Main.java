// LeetCode Problem: https://leetcode.com/problems/reorder-list/

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
    private ListNode reverse(ListNode head){
        if(head == null)
            return head;
        
        ListNode curr = head, prev = null;
        while(curr != null){
            ListNode nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode list1 = head, list2 = reverse(slow.next);
        slow.next = null;

        while(list2 != null){
            ListNode list1nex = list1.next, list2nex = list2.next;
            list1.next = list2;
            list2.next = list1nex;
            list1 = list1nex;
            list2 = list2nex;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Reorder the list
        Solution solution = new Solution();
        solution.reorderList(head);

        // Print the reordered list
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
