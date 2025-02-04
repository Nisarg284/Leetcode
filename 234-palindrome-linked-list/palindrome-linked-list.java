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


    public static boolean isValid(ListNode head,ListNode[] ref)
    {
        if(head == null)
        {
            return true;
        }

        boolean flag = isValid (head.next,ref);

        if(!flag || head.val != ref[0].val)
        {
            return false;
        }
        ref[0] = ref[0].next;
        return true;
    }

    
    public boolean isPalindrome(ListNode head) {

        ListNode[] ref = new ListNode[1];
        ref[0] = head;

        return isValid(head,ref);


        // ListNode slow = head;
        // ListNode fast = head;

        // while(fast!=null && fast.next!=null)
        // {
        //     slow =slow.next;
        //     fast = fast.next.next;
        // }

        // ListNode newLL = slow;

        // ListNode prev = null;
        // ListNode curr = newLL;
        // ListNode next;

        // while(curr!=null)
        // {
        //     next = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = next;
        // }

        // slow.next = prev;

        // ListNode h1 = head;
        // ListNode h2 = prev;

        // while(h1!=slow)
        // {
        //     if(h1.val!=h2.val)
        //     {
        //         return false;
        //     }
        //     h1=h1.next;
        //     h2 = h2.next;
        // }

        // return true;

// <--------------------------------------------------->

        // ListNode slow=head;
        // ListNode fast=head;
        
        // while(fast!=null && fast.next!=null)
        // {
        //     slow=slow.next;
        //     fast=fast.next.next;
        // }
        
        // ListNode mid=slow;
    
        
        // ListNode prev=null;
        // ListNode curr=mid;
        // ListNode next;
        
        // while(curr!=null)
        // {
        //     next=curr.next;
        //     curr.next=prev;
        //     prev=curr;
        //     curr=next;
        // }
        
        // ListNode rightHead=prev;
        // ListNode leftHead=head;
        
        // while(rightHead!=null)
        // {
        //     if(leftHead.val!=rightHead.val)
        //     {
        //         return false;
        //     }
        //     leftHead=leftHead.next;
        //     rightHead=rightHead.next;
        // }
        
        // return true;
        
    }
}