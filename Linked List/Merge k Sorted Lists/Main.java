// LeetCode Problem: https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.Comparator;
import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.val));

        for(int i=0; i< lists.length; i++){
            ListNode temp = lists[i];
            while(temp != null){
                pq.add(temp);
                temp = temp.next;
            }
        }

        if(pq.isEmpty())
            return null;
        
        ListNode ans = new ListNode(pq.poll().val);
        ListNode ptr = ans;

        while(!pq.isEmpty()){
            ptr.next = new ListNode(pq.poll().val);
            ptr = ptr.next;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        // Example usage
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));

        Solution solution = new Solution();
        ListNode mergedList = solution.mergeKLists(lists);

        // Print merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
