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

    public static int llSize (ListNode head)
    {
        int size = 0;
        if(head == null)
        {
            return 0;
        }

        ListNode temp = head;
        while(temp!=null)
        {
            temp = temp.next;
            size++;
        }

        return size;
    }

    public static ListNode remove(ListNode head,int size, int n)
    {
        if(size == n)
        {
            return head.next;
        }

        head.next = remove(head.next,size-1,n);
        return head;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int size = llSize(head);
        return remove(head,size,n);
       
        
    }
}