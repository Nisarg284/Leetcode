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


    public static int helper(TreeNode root,int[]moves){
        if(root == null){
            return 0;
        }


        int left = helper(root.left,moves);
        int right = helper(root.right,moves);

        moves[0] += (Math.abs(left) + Math.abs(right));

        return left + right + root.val - 1; 
    }
    public int distributeCoins(TreeNode root) {


        int[]moves = new int[1];

        helper(root,moves);

        return moves[0];
        
    }
}