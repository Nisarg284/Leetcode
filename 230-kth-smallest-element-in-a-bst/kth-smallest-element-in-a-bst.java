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


    public void inorderHelper(TreeNode root,int[]kth,int[]ans)
    {
        if(root == null)
        {
            return;
        }

        if(ans[0]!=-1)
        {
            return;
        }


        inorderHelper(root.left,kth,ans);

        // System.out.print(root.val+" ---> ");
        
        // // else{
            kth[0]--;
        // // }

        if(kth[0] == 0)
        {
            ans[0] = root.val;
            // return;
        }
        inorderHelper(root.right,kth,ans);

        
    }
    public int kthSmallest(TreeNode root, int k) {





        int[] ans = {-1};
        int[] kth = {k};
        inorderHelper(root,kth,ans);


        return ans[0];
        
    }
}