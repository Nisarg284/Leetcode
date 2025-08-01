/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    // public static boolean isExists(TreeNode root,TreeNode target)
    // {
    //     if(root == null)
    //     {
    //         return false;
    //     }

    //     if(root == target)
    //     {
    //         return true;
    //     }

    //     return isExists(root.left,target) || isExists(root.right,target);
    // }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root == p || root == q)
        {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null)
        {
            return root;
        }

        if(left != null)
        {
            return left;
        }

        return right;
    
        
    }
}