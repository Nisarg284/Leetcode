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
    public void reorderList(ListNode head) {

        ListNode temp = head;
        int size = 0;
        while(temp!=null)
        {
            temp = temp.next;
            size++;
        }

        temp = head;
        // ListNode rightHead;
        
            for(int i=0;i<size/2;i++)
            {
                temp = temp.next;
            }
        ListNode rightHead = temp.next;

        temp.next = null;
        // now reverse second half

        ListNode prev = null;
        ListNode curr = rightHead;
        ListNode next;

        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // define iterators
        ListNode dummy = new ListNode(0);
        ListNode d1 = dummy;
        rightHead = prev;

        temp = head;
        ListNode t2 = rightHead;


        boolean flag = false;

        while(temp!=null && t2!=null)
        {

            if(!flag)
            {
                d1.next = temp;
                temp = temp.next;
                d1 = d1.next;
                flag = true;
            }else{
                d1.next = t2;
                t2 = t2.next;
                d1 = d1.next;
                flag = false;
            }
        }

        if(temp!=null)
        {
            d1.next = temp;
            temp = temp.next;
        }

        if(t2!=null)
        {
            d1.next = t2;
            t2 = t2.next;
        }

        head = dummy.next;

        // return dummy.next;        
    }
}