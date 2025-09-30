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

    public static void helper(TreeNode root,int currSum,int[]totalSum)
    {
        if(root == null)
        {
            return;
        }

        int curr = (currSum * 10) + root.val;
        // System.out.println(curr);

        if(root.left == null && root.right == null)
        {
            totalSum[0] += curr;
            return;
        }

        helper(root.left,curr,totalSum);
        helper(root.right,curr,totalSum);
    }

    public int sumNumbers(TreeNode root) {

        if(root == null)
        {
            return 0;
        }

        int[] ans = new int[1];

        helper(root,0,ans);

        return ans[0];
    }
}