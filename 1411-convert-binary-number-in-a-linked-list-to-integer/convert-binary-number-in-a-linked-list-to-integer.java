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
    public int getDecimalValue(ListNode head) {

        if(head == null)
        {
            return 0;
        }

        // reverse LinkedList

        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode newHead = prev;

        ListNode temp =  newHead;

        int num = 0;
        int a = 1;
        while(temp!=null)
        {
            num += a*temp.val;
            temp = temp.next;
            a*=2;
        }

        return num;
        
    }
}