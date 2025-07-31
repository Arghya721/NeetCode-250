// LeetCode Problem: https://leetcode.com/problems/add-two-numbers/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode temp = sum;
        int carry = 0;
        while(l1 != null && l2 != null){
            int add = l1.val + l2.val + carry;
            carry = add / 10;
            add = add % 10;
            temp.next = new ListNode(add);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int add = l1.val + carry;
            carry = add/10;
            add = add % 10;
            temp.next = new ListNode(add);
            temp = temp.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int add = l2.val + carry;
            carry = add/10;
            add = add % 10;
            temp.next = new ListNode(add);
            temp = temp.next;
            l2 = l2.next;
        }

        if(carry > 0)
            temp.next = new ListNode(carry);

        return sum.next;
    }
}


public class Main {
    public static void main(String[] args) {
        // Create two linked lists: 342 (2 -> 4 -> 3) and 465 (5 -> 6 -> 4)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Add the two numbers
        Solution solution = new Solution();
        ListNode sum = solution.addTwoNumbers(l1, l2);

        // Print the result
        while (sum != null) {
            System.out.print(sum.val + " ");
            sum = sum.next;
        }
    }
}
