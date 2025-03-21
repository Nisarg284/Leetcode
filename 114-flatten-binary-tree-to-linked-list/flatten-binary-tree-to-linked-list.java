/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) 
            {
                TreeNode pred = curr.left;
                while (pred.right != null) 
                {
                    pred = pred.right;
                }

                TreeNode temp = curr.right;
                curr.right = curr.left;

                pred.right = temp;
                // curr.right = pred;
                curr.left = null;

            }
            curr = curr.right;
        }

    }
}