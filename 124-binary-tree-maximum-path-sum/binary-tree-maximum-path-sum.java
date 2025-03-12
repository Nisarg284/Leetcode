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
    public static int helper(TreeNode root,int[]ans)
    {
        if(root == null)
        {
            return 0;
        }

        int left = Math.max(0,helper(root.left,ans));
        int right = Math.max(0,helper(root.right,ans));

        int temp = root.val + Math.max(left,right);
        ans[0] = Math.max(ans[0],root.val + left + right);

        return temp;
    }
    public int maxPathSum(TreeNode root) {

        if(root == null)
        {
            return 0;
        }

        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;

        helper(root,ans);

        return ans[0];
        
    }
}