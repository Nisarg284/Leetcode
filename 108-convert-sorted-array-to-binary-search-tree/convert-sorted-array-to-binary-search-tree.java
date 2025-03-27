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

    public static TreeNode helper(int[] nums,int i,int j)
    {
        if(i>j)
        {
            return null;
        }

        int mid = (i + j)/2;
        int val = nums[mid];

        TreeNode root = new TreeNode(val);

        root.left = helper(nums,i,mid-1);
        root.right = helper(nums,mid+1,j);

        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {

        int n = nums.length;

       TreeNode root =  helper(nums,0,n-1);

        return root;
        
    }
}