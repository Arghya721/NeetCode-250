// LeetCode Problem: https://leetcode.com/problems/reverse-linked-list-ii/

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
    ListNode reverse(ListNode head, int limit){
        ListNode curr = head, prev = null;

        while(limit > 0){
            ListNode nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
            limit--;
        }

        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right)
            return head;

        ListNode leftNode = head, rightNode = null, temp = head;
        int nodeCount = 1;

        while(temp != null){
            if(nodeCount == left - 1)
                leftNode = temp;
            
            if(nodeCount == right + 1){
                rightNode = temp;
                break;
            }
            nodeCount++;
            temp = temp.next;
        }
        ListNode start = (left == 1) ? head : leftNode.next;

        ListNode endNode = start;
        ListNode newHead = reverse(start, right - left + 1);

        if (left == 1) {
            head = newHead;
        } else {
            leftNode.next = newHead;
        }

        endNode.next = rightNode;

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

        // Reverse the linked list from position 2 to 4
        Solution solution = new Solution();
        head = solution.reverseBetween(head, 2, 4);

        // Print the modified linked list
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
