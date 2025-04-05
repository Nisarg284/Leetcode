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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((p1,p2)->Integer.compare(p1.val,p2.val));
        
        for(int i=0;i<lists.length;i++)
        {
            if(lists[i]!=null)
            {
                pq.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!pq.isEmpty())
        {
            ListNode temp = pq.remove();
            curr.next = temp;
            curr = curr.next;

            if(temp.next!=null)
            {
                pq.add(temp.next);
            }
            
        }

        ListNode head = dummy.next;
        return head;
        
    }
}