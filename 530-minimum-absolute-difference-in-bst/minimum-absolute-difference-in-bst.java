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


    public static void helper(TreeNode root,int[]ans,TreeNode[]prev)
    {
        if(root == null)
        {
            return;
        }

        // if(ans[0] > diff)
        // {
        //     prev[0] = root;
        //     ans[0] = diff;
        // }

        helper(root.left,ans,prev);

        if(prev[0] != null)
        {
            ans[0] = Math.min(ans[0],Math.abs(root.val - prev[0].val));
        }

        prev[0] = root;
        helper(root.right,ans,prev);
    }
    public int getMinimumDifference(TreeNode root) {

        if(root == null)
        {
            return 0;
        }

        int[]ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        TreeNode[]prev = new TreeNode[1];
        prev[0] = null;

        helper(root,ans,prev);

        return ans[0];
        
    }
}