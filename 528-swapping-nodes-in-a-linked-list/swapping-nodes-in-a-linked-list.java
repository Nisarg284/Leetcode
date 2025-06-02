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

    public static int length(ListNode head)
    {
        ListNode temp = head;

        int len = 0;
        while(temp != null)
        {
            temp = temp.next;
            len++;
        }

        return len;
    }
    public ListNode swapNodes(ListNode head, int k) {

        ListNode swap1 = head;

        int moves = k;

        int size = length(head);

        while (swap1!=null && moves > 1)
        {
            swap1 = swap1.next;
            moves--;
        }

        ListNode swap2 = head;

        for(int i = 0;i<size-k && swap2!=null;i++)
        {
            swap2 = swap2.next;
        }

        int temp = swap1.val;
        swap1.val = swap2.val;
        swap2.val = temp;

        return head;
    }
}