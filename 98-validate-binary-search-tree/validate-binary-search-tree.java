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

    static TreeNode prev;

    public static boolean inOrderTraversal(TreeNode root)
    {
        if(root == null)
        {
            return true;
        }

        if(!inOrderTraversal(root.left))
        {
            return false;
        }

        if(prev!=null && prev.val>=root.val)
        {
            return false;
        }

        prev = root;
        return inOrderTraversal(root.right);

    }
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inOrderTraversal(root);
        
    }
}