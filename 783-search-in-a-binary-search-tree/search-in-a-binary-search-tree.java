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

    public void helper(TreeNode root,int val,TreeNode[]ans)
    {
        if(root == null)
        {
            return;
        }

        if(root.val == val)
        {
            ans[0] = root;
            return;
        }else if(root.val < val)
        {
            helper(root.right,val,ans);
        }else{
            helper(root.left,val,ans);
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {

        // if(root == null )
        // {
        //     return root;
        // }
        // else if(root.val == val)
        // {
        //     return root;
        // }
        //  else if(root.val < val)
        // {
        //     return searchBST(root.right,val);
        // }
    
        // return searchBST(root.left,val);

        TreeNode[] ans = new TreeNode[1];
        helper(root,val,ans);

        return ans[0];


        
    }
}