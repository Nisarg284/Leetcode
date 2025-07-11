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

    public static void helper(TreeNode root,int min,int max,int[]maxDiff)
    {
        if(root == null)
        {
            return;
        }

        int currDiff = Math.max(Math.abs(root.val - min) , Math.abs(root.val-max));

        maxDiff[0] = Math.max(currDiff,maxDiff[0]);

        min = Math.min(root.val,min);
        max = Math.max(root.val,max);

        helper(root.left,min,max,maxDiff);  
        helper(root.right,min,max,maxDiff);  
    }
    public int maxAncestorDiff(TreeNode root) {

        int min = root.val;
        int max = root.val;
        int[] maxDiff = new int[1];

        helper(root,min,max,maxDiff);

        return maxDiff[0];
        
    }
}