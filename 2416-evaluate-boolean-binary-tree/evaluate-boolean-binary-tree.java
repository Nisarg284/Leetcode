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
    public boolean evaluateTree(TreeNode root) {

        if(root.left == null && root.right == null)
        {
            if(root.val == 0)
            {
                return false;
            }

            if(root.val == 1)
            {
                return true;
            }
        }

        boolean a = evaluateTree(root.left);
        boolean b = evaluateTree(root.right);

        if(root.val == 2)
        {
            return a || b;
        }

        return a && b;
        
    }
}