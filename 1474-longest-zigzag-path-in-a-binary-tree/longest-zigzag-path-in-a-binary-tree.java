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

    public static void helper(TreeNode root,int[]ans,int leftCount,int rightCount)
    {
        if(root == null)
        {
            return;
        }

        ans[0] = Math.max(ans[0],Math.max(leftCount,rightCount));

        if(root.left!=null)
        {
            helper(root.left,ans,rightCount+1,0);
        }

         if(root.right!=null)
        {
            helper(root.right,ans,0,leftCount+1);
        }
    }

    public int longestZigZag(TreeNode root) {

        if(root == null)
        {
            return 0;
        }

        int[] ans = new int[1];

        helper(root,ans,0,0);

        return ans[0];
        
    }
}