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

    public static void helper(TreeNode root,int[]kth,int[]ans){
        if( ans[0] != -1 || root == null){
            return;
        }

        helper(root.left,kth,ans);
        kth[0]--;
        if(kth[0] == 0){
            ans[0] = root.val;
            return;
        }

        helper(root.right,kth,ans);

    }
    public int kthSmallest(TreeNode root, int k) {


        int[]kth = {k};
        int[]ans = {-1};

        helper(root,kth,ans);

        return ans[0];


        
    }
}