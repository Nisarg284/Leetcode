
// class Solution {

//     public static int findSize(ListNode head){
//         int size = 0;
//         while(head!=null)
//         {
//             head = head.next;
//             size++;
//         }

//         return size;
//     }
//     public int[] nextLargerNodes(ListNode head) {
        

//         // reverse list
//         ListNode curr = head;
//         ListNode prev = null;
//         ListNode next;

//         while(curr!=null)
//         {
//             next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }

//         ListNode newHead = prev;

//         Stack<ListNode> st = new Stack<>();

//         int size = findSize(newHead);

//         int[] ans = new int[size];
//         ans[size-1] = 0;
//         int i = size - 2;

//         ListNode temp = newHead;

//         while(temp.next!=null)
//         {
//             while(!st.isEmpty() && st.peek().val < temp.val)
//             {
//                 st.pop();
//             }
//             if(!st.isEmpty())
//             {
//                 ans[i] = st.peek().val;
//             }else{
//                 ans[i] = 0;
//             }

//             st.push(temp);
//             temp = temp.next;
//             i--;
//         }

//         return ans;
//     }
// }


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        
        int[] ans = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                ans[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }
        
        return ans;
    }
}