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
    public ListNode modifiedList(int[] nums, ListNode head) {

        
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            hs.add(nums[i]);
        }

        while(head!=null && hs.contains(head.val))
        {
            head = head.next;
        }

        if(head == null)
        {
            return null;
        }

        ListNode curr = head;
        ListNode temp = head.next;

        while(temp!=null)
        {
            if(hs.contains(temp.val))
            {
                curr.next = temp.next;
                temp = temp.next;
            }else{
                curr.next = temp;
                curr = temp;
                temp = temp.next;
            }
        }

        return head;
        
    }
}