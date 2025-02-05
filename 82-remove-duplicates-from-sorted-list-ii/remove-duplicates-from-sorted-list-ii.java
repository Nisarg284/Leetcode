/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null)
        {
            return head;
        }

        // Define dummu node
        ListNode dummy = new ListNode(-1000);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = prev.next;

        while(curr!= null && curr.next!=null)
        {
            if(curr.val == curr.next.val)
            {
                while(curr.next!=null && curr.val == curr.next.val)
                {
                    curr = curr.next;
                }
                prev.next = curr.next;
            }else
            {
                prev = prev.next;
            }
            curr = curr.next;
           
        }
        return dummy.next;

        
        
    }
}