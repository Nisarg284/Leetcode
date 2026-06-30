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

    public static ListNode reverseList(ListNode head){

        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr != null){

            next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
        }

        return prev;
    }
    public ListNode removeNodes(ListNode head) {


        ListNode reverseHead = reverseList(head);

        ListNode temp = reverseHead;

        while(temp != null){

            ListNode curr = temp;

            temp = temp.next;

            while( temp != null && temp.val < curr.val){
                temp = temp.next;
            }

            curr.next = temp;
        }

        ListNode newHead = reverseList(reverseHead);

        return newHead;

        



        
    }
}