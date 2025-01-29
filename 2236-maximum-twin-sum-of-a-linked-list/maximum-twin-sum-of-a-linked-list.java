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
    public int pairSum(ListNode head) {

         ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null)
        {
            slow =slow.next;
            fast = fast.next.next;
        }

        ListNode newLL = slow;

        ListNode prev = null;
        ListNode curr = newLL;
        ListNode next;

        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        slow.next = prev;

        ListNode h1 = head;
        ListNode h2 = prev;
        int maxSum = Integer.MIN_VALUE;

        while(h1!=slow)
        {
            maxSum = Math.max(maxSum,h1.val+h2.val);
            
            h1=h1.next;
            h2 = h2.next;
        }
        return maxSum;
    }
}