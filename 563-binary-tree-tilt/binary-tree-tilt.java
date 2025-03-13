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

    public static int helper(TreeNode root,int[]sum)
    {
         if(root == null)
        {
            return 0;
        }

        if(root.left == null && root.right == null)
        {
            return root.val;
        }

        int left =  helper(root.left,sum);
        int right = helper(root.right,sum);

        sum[0] += Math.abs(left - right);

        return left + right + root.val;
    }
    public int findTilt(TreeNode root) {


        if(root == null)
        {
            return 0;
        }

        int[] sum = new int[1];

        helper(root,sum);

        return sum[0];
        
    }
}