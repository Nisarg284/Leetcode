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
    public ListNode partition(ListNode head, int x) {

        // Dummy Heads
        ListNode less = new ListNode(0);
        ListNode greater = new ListNode(0);

        // itertor Nodes
        ListNode lt = less;
        ListNode gt = greater;

        while(head!=null)
        {
            if(head.val < x)
            {
                lt.next = head;
                lt = lt.next;
            }else{
                gt.next = head;
                gt = gt.next;
            }
            head = head.next;
        }

        lt.next = greater.next;
        gt.next = null;

        return less.next;
        
    }
}