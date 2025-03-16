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

    public static void helper(TreeNode root, int k,PriorityQueue<Integer> pq)
    {
        if(root == null)
        {
            return;
        }

        pq.add(root.val);
        if(pq.size() > k)
        {
            pq.remove();
        }

        helper(root.left,k,pq);
        helper(root.right,k,pq);
    }
    public int kthSmallest(TreeNode root, int k) {

        if(root == null)
        {
            return 0;
        }


        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        pq.add(root.val);
        helper(root.left,k,pq);
        helper(root.right,k,pq);

        return pq.peek();
        
    }
}