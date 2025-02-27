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
   
    public ListNode reverseKGroup(ListNode head,int k){

        if(head == null || k == 1)
        {
            return head;
        }
        // create a dummy ListNode
        ListNode dummy = new ListNode(0);
        dummy.next = head;


//        int idx = 1;
        ListNode prevHead = dummy;

        while (true){

            int count = 0;
            ListNode check = prevHead.next;

            while(check!=null && count <k)
            {
                check = check.next;
                count++;
            }

            if(count < k)
            {
                break;
            }

//            prevTail
            ListNode curr = prevHead.next;
            ListNode prev = null;
//            nextTail.next = check.next;
//            prevHead.next = curr;
//            prevHead = curr;

            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;

            }

            ListNode newTail = prevHead.next;
            prevHead.next = prev;
            prevHead = newTail;
            newTail.next = curr;
            prevHead = newTail;

            if (curr == null) break;


//            if(idx%k == 0)
//            {
//                ListNode prevNext = prevHead.next;
//                prevNext = next;
//                prevHead.next = curr;
//            }else{
//                next = curr.next;
//                curr.next = prev;
//                prev = curr;
//                curr = next;
//            }
//            idx++;

        }

        return dummy.next;

    }

}