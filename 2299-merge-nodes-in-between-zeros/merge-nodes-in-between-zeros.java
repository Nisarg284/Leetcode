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
// class Solution {
//     public ListNode mergeNodes(ListNode head) {

//         ListNode i = head.next;

//         while(i!=null)
//         {
//             ListNode j = i;

//             int sum = 0;
//             while(j!=null && j.val != 0)
//             {
//                 sum += j.val;
//                 j = j.next;
//             }

//             i.val = sum;
//             i.next = j.next;
//             i = j.next;
           
//         }

//         return head.next;
        
//     }
// }


class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head.next;  // Skip initial 0
        ListNode sumNode = curr;    // Node to hold sum
        
        while (curr != null) {
            if (curr.val == 0 && sumNode != curr) {  // End of segment
                sumNode.next = curr.next;            // Skip to next segment
                sumNode = curr.next;                 // Move to next sum node
            } else {                                // Add to sum
                if(sumNode!=curr)
                {
                    sumNode.val += curr.val;
                }
            }
            curr = curr.next;
        }
        
        return head.next;
    }
}