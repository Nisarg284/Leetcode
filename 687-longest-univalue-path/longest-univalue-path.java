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

    public static int helper(TreeNode root,int[] ans)
    {
        if(root == null)
        {
            return 0;
        }

        int left = helper(root.left,ans);
        int right = helper(root.right,ans);

        int leftCount = 0;
        int rightCount = 0;



        if(root.left!= null && root.val == root.left.val)
        {
            leftCount = left + 1;
        }

        if(root.right!= null && root.val == root.right.val)
        {
            rightCount = right + 1;
        }

        ans[0] = Math.max(ans[0],leftCount + rightCount);

        return Math.max(leftCount,rightCount);
    }
    public int longestUnivaluePath(TreeNode root) {

        if(root == null)
        {
            return 0;
        }

        int ans[] = new int [1];

        helper(root,ans);

        return ans[0];
        
    }
}