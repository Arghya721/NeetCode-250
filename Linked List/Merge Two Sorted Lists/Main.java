// LeetCode Problem: https://leetcode.com/problems/merge-two-sorted-lists/

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(0);
        ListNode curr = ans;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        while(list1 != null){
            curr.next = list1;
            list1 = list1.next;
            curr = curr.next;
        }

        while(list2 != null){
            curr.next = list2;
            list2 = list2.next;
            curr = curr.next;
        }

        return ans.next;
    }
}



public class Main {
    public static void main(String[] args) {
        // Create first sorted linked list: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // Create second sorted linked list: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // Merge the two lists
        Solution solution = new Solution();
        ListNode mergedList = solution.mergeTwoLists(list1, list2);

        // Print the merged linked list
        ListNode curr = mergedList;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
