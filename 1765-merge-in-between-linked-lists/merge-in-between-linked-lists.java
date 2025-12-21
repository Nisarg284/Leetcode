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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        


        int idx = 0;
        int stop1 = a-1;

        ListNode temp = list1;

        while(temp != null && idx != stop1)
        {
            temp = temp.next;
            idx++;
        }

        ListNode newStart = temp;
        temp = temp.next;
        newStart.next = list2;

        ListNode temp2 = list2;

        while(temp2.next != null)
        {
            temp2 = temp2.next;
        }


        while(temp != null && idx != b-1)
        {
            temp = temp.next;
            idx++;
        }

        temp2.next = temp.next;

        return list1;
    }
}