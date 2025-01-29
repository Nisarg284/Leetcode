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
    public ListNode oddEvenList(ListNode head) {

        if(head == null || head.next == null || head.next.next == null)
        {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;


        while(even!=null && even.next!=null)
        {
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = odd.next; 


            // odd.next = even.next;   // Connect odd nodes
            // odd = odd.next;
            // even.next = odd.next;   // Connect even nodes
            // even = even.next;
            
        }

        odd.next = evenHead;
        return head;
        
        
    }
}