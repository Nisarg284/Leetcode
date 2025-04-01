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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public static TreeNode helper(ArrayList<Integer> al,int i,int j)
    {
        if(i > j)
        {
            return null;
        }

        int mid = (i+j)/2;
        TreeNode root = new TreeNode(al.get(mid));

        root.left= helper(al,i,mid-1);
        root.right = helper(al,mid+1,j);

        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {

        ArrayList<Integer> al = new ArrayList<>();

        while(head!=null)
        {
            al.add(head.val);
            head = head.next;
        }

        return helper(al,0,al.size()-1);
    }
}