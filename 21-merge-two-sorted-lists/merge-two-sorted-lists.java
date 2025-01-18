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

    // public void merge(ListNode l1,ListNode l2,ListNode ans)
    // {
    //     ListNode temp1=l1;
    //     ListNode temp2 = l2;

    //     ListNode Head = new ListNode(-1);
    //     ListNode temp3 = head;

        

    //     while(temp1!= null && temp2!= null)
    //     {
    //         if(temp1.data < temp2.data)
    //         {
    //             ListNode newNode = temp1;
    //             temp3.next = newNode;
    //             temp3 = temp3.next;
    //             temp1 = temp1.next;
    //         }else
    //         {
    //             ListNode newNode = temp2;
    //             temp3.next = newNode;
    //             temp3 = temp3.next;
    //             temp2 = temp2.next;
    //         }

    //     }

    // }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
 ListNode temp1=list1;
        ListNode temp2 = list2;

        ListNode Head = new ListNode(-1);
        ListNode temp3 = Head;

        

        while(temp1!= null && temp2!= null)
        {
            if(temp1.val < temp2.val)
            {
                ListNode newNode = temp1;
                temp3.next = newNode;
                temp3 = temp3.next;
                temp1 = temp1.next;
            }else
            {
                ListNode newNode = temp2;
                temp3.next = newNode;
                temp3 = temp3.next;
                temp2 = temp2.next;
            }
        }

        while(temp1!=null)
        {
            ListNode newNode = temp1;
                temp3.next = newNode;
                temp3 = temp3.next;
                temp1 = temp1.next;

        }

        while(temp2!=null)
        {
            ListNode newNode = temp2;
                temp3.next = newNode;
                temp3 = temp3.next;
                temp2 = temp2.next;

        }

        return Head.next;
        
    }
}