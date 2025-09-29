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

    public static int[] helper(TreeNode root)
    {
        if(root == null)
        {
            return new int[]{0,0};
        }

        int[] leftAns = helper(root.left);
        int[] rightAns = helper(root.right);

        int take = root.val + leftAns[1] + rightAns[1];

        int skip = Math.max(leftAns[0],leftAns[1]) + Math.max(rightAns[0],rightAns[1]);

        return new int[]{take,skip};

        // if(status)
        // {
        //     int accept = helper(root.left,false) + helper(root.right,false);
        //     int take = root.val + accept;
        //     int skip = helper(root.left,true) + helper(root.right,true);
        //     return Math.max(take,skip);
        // }else{
        //     return helper(root.left,true) + helper(root.right,true);
        // }
    }
    public int rob(TreeNode root) {

        int[] ans = helper(root);


        return Math.max(ans[0],ans[1]);
        
    }
}