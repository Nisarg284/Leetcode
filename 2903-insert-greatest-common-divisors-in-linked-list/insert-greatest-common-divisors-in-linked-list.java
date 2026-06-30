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

    public static int gcdFinder(int num1,int num2){

        if(num2 == 0){
            return num1;
        }

        return gcdFinder(num2,num1 % num2);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        if(head.next == null){
            return head;
        }

        ListNode num1 = head;
        ListNode num2 = num1.next;

        while(num2 != null){

            int gcdNum = gcdFinder(num1.val,num2.val);
            System.out.println(gcdNum);
            ListNode gcd = new ListNode(gcdNum);

            num1.next = gcd;
            gcd.next = num2;

            num1 = num2;
            num2 = num2.next;
        }

        return head;


        
    }
}