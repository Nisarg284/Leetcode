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

    public static int helper(TreeNode root,int[]maxSum)
    {
        if(root == null)
        {
            return 0;
        }

        int leftSum = Math.max(helper(root.left,maxSum),0);
        int rightSum = Math.max(helper(root.right,maxSum),0);

        int pathSum = root.val + leftSum +rightSum;
        maxSum[0] = Math.max(maxSum[0],pathSum);

        return root.val + Math.max(leftSum,rightSum);
    }
    public int maxPathSum(TreeNode root) {
        int[]maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        int ans = helper(root,maxSum);
        return maxSum[0];
        
    }
}