/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> hs1 = new HashSet<>();
        

        ListNode temp1 = headA;
        while(temp1!=null)
        {
            hs1.add(temp1);
            temp1 = temp1.next;
        }

        ListNode temp2 = headB;
        ListNode ans = null;

        while(temp2!=null)
        {
            if(hs1.contains(temp2))
            {
                ans = temp2;
                break;
            }
            temp2 = temp2.next;
        }

       

        return ans;
        
    }
}