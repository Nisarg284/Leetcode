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

    public static void helper(TreeNode root,int[]count,int prev)
    {
        if(root == null)
        {
            return;
        }

        if(root.val >= prev)
        {
            count[0]++;
            prev = root.val;
        }

        helper(root.left,count,prev);
        helper(root.right,count,prev);


        


    }
    public int goodNodes(TreeNode root) {

        if(root == null)
        {
            return 0;
        }


        int[] ans = new int[1];
        ans[0] = 1;

        helper(root.left,ans,root.val);
        helper(root.right,ans,root.val);

        return ans[0];


        
    }
}