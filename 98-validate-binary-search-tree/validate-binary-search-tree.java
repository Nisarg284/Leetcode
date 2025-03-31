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

    public static void helper(TreeNode root,TreeNode[] prev,boolean[] flag)
    {
        if(root == null)
        {
            return;
        }

        helper(root.left,prev,flag);

        // if(prev[0] == null)
        // {
        //     prev[0] = root;
        // }else if(root.val <= prev[0].val)
        // {
        //     flag[0] = false;
        // }else{
        //     prev[0] = root;
        // }

         if(prev[0] != null && prev[0].val >= root.val)
            {
                flag[0] = false;
            }

            prev[0] = root;

        helper(root.right,prev,flag);
    }
    public boolean isValidBST(TreeNode root) {

        TreeNode[] prev = new TreeNode[1];
        boolean[] flag = new boolean[1];

        prev[0] = null;
        flag[0] = true;

        helper(root,prev,flag);

        return flag[0];
        
    }
}