/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {

        // int length = 0;

        // ListNode temp = head;
        // while(temp!=null)
        // {
        // temp = temp.next;
        // length++;
        // }

        // int lengthOfPart = length/k;

        // int needParts = k-1;
        // int doneParts = 0;
        // ListNode[] ans = new ListNode[k];
        // int i = 0;
        // while(head!=null && doneParts<needParts)
        // {
        // int count = 1;
        // ListNode t1 = head;
        // while(count < lengthOfPart)
        // {
        // head = head.next;
        // count++;
        // }

        // ListNode newHead = head.next;
        // head.next = null;
        // ans[i] = t1;
        // head = newHead;
        // doneParts++;
        // i++;
        // }

        // ListNode lastPart = head.next;
        // head.next = null;
        // ans[i] = lastPart;

        // return ans;

        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        int lengthOfPart = length / k;
        int extraNodes = length % k;

        ListNode[] ans = new ListNode[k];
        ListNode current = head;

        for (int i = 0; i < k && current != null; i++) {
            ans[i] = current; 

            
            int partSize = lengthOfPart + (extraNodes > 0 ? 1 : 0);
            extraNodes--; 

            
            for (int j =1; j < partSize; j++) 
            {
                current = current.next;
            }

            
            ListNode next = current.next;
            current.next = null;
            current = next;
        }

        return ans;
    }
}