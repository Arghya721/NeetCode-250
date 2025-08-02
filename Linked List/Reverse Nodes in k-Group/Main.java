// LeetCode Problem: https://leetcode.com/problems/reverse-nodes-in-k-group/

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
    int countLL(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }

        return count;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = countLL(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while(count >= k){
            ListNode curr = prev.next;
            ListNode next = curr.next;
            for(int i=1; i<k; i++){
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            count -= k;
        }

        return dummy.next;
    }
}


public class Main {
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 2;

        Solution solution = new Solution();
        ListNode reversedList = solution.reverseKGroup(head, k);

        // Print reversed list
        while (reversedList != null) {
            System.out.print(reversedList.val + " ");
            reversedList = reversedList.next;
        }
    }
}
