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


    public static int helper(TreeNode root,int[]ans){
        if(root == null){
            return 2;
        }


        int left = helper(root.left,ans);
        int right = helper(root.right,ans);

        if(left == 0 || right == 0){

            ans[0]++;
            return 1;
        }

        if(left == 1 || right == 1){
            return 2;
        }


        return 0;
    }
    public int minCameraCover(TreeNode root) {

        if(root.left == null && root.right == null){
            return 1;
        }


        int[]ans = {0};

        int trees = helper(root,ans);

        if(trees == 0){
            return ++ans[0];
        }

        return ans[0];
        
    }
}


