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

    public static void helper(TreeNode root,ArrayList<Integer>sorted)
    {
        if(root == null)
        {
            return;
        }

        // if(root.left == null && root.right == null)
        // {
        //     sorted.add(root.val);
        //     return;
        // }

        helper(root.left,sorted);
        sorted.add(root.val);
        helper(root.right,sorted);

    }
    public boolean isValidBST(TreeNode root) {

        ArrayList<Integer> sorted = new ArrayList<>();
        helper(root,sorted);

        for(int i=0;i<sorted.size()-1;i++)
        {
            if(sorted.get(i) >= sorted.get(i+1))
            {
                return false;
            }
        }

        return true;
        
    }
}