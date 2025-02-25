/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        // if(head == null ||head.next == null)
        // {
        // return head;
        // }

        // ListNode temp = head;
        // int count = 0;

        // while(temp.next!=null)
        // {
        // if(count % 2 ==0 )
        // {
        // int v = temp.val;
        // temp.val = temp.next.val;
        // temp.next.val = v;
        // }

        // temp = temp.next;
        // count++;
        // }

        // return head;

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr!= null &&curr.next != null) {
             ListNode next = curr.next;

        // Swapping nodes
        curr.next = next.next;
        next.next = curr;
        prev.next = next;

        // Moving to the next pair
        prev = curr;
        curr = curr.next;

            // ListNode curr = prev.next; 
            // ListNode next = curr.next; 

            // // Perform the swap
            // curr.next = next.next; 
            // next.next = curr; 
            // prev.next = next; 

            // prev = curr;
            // next = curr.next;

            // if(next.next!= null)
            // {
            // curr.next = next.next;
            // next.next = curr;
            // prev.next = next;
            // }
            // prev = curr;
            // curr = curr.next;
        }

        return dummy.next;

        // ListNode curr = head;
        // ListNode next = head.next;

        // while(curr != null && next != null)
        // {
        // // swap
        // int temp = curr.val;
        // curr.val = next.val;
        // next.val = temp;

        // curr = next.next;
        // if(curr!=null)
        // {
        // next = curr.next;
        // }
        // }
        // return head;
    }
}