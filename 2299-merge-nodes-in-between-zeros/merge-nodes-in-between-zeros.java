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
    public ListNode mergeNodes(ListNode head) {

        ListNode i = head.next;

        while(i!=null)
        {
            ListNode j = i;

            int sum = 0;
            while(j!=null && j.val != 0)
            {
                sum += j.val;
                j = j.next;
            }

            i.val = sum;
            i.next = j.next;
            i = j.next;
           
        }

        return head.next;
        
    }
}