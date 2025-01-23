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
    public ListNode swapPairs(ListNode head) {

        if(head == null ||head.next == null)
        {
            return head;
        }

        ListNode temp = head;
        int count = 0;

        while(temp.next!=null)
        {
            if(count % 2 ==0 )
            {
                int v = temp.val;
                temp.val = temp.next.val;
                temp.next.val = v;
            }

            temp = temp.next;
            count++;
        }

        return head;


        // if(head == null || head.next == null)
        // {
        //     return head;
        // }
        
        // ListNode curr = head;
        // ListNode next = head.next;

        // while(curr != null && next != null)
        // {
        //     // swap
        //     int temp = curr.val;
        //     curr.val = next.val;
        //     next.val = temp;
            
        //     curr = next.next;
        //     if(curr!=null)
        //     {
        //         next = curr.next;
        //     }
        // }
        // return head;
    }
}