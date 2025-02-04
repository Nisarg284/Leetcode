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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int idx = 1;

        ListNode temp = dummy;

        // traverse up to left-1
        while(idx < left )
        {
            temp = temp.next;
            idx++;
        }

        // now Stroe temp node as left head
        ListNode leftHead = temp;

        // store temp.next into newLeftHead
        ListNode newLeftHead = temp.next;

        // now cut connection of temp to newLeftHead
        // temp.next = null;

        // Assign prev - curr - next nodes for reversing LinkedList upto right
        // we traverse upto right+1

        ListNode prev = null;
        ListNode curr = newLeftHead;
        ListNode next;


        idx = 0;

        // travrse unitl idx != right+1 Or curr!=null
        while(idx < right-left+1 && curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            idx++;
        }


        // check if curr == null that means prev is our last node of linked list.
        leftHead.next = prev;
        newLeftHead.next = curr;

        return dummy.next;

    }
}