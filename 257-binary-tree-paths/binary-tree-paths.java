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

    public static void helper(TreeNode root,String s,List<String>ans)
    {
        if(root == null)
        {
            return;
        }

        s+=root.val;

        if(root.left == null && root.right == null)
        {
            ans.add(s);
            return;
        }

        helper(root.left,s+"->",ans);
        helper(root.right,s+"->",ans);
    }
    public List<String> binaryTreePaths(TreeNode root) {

        if(root == null)
        {
            return new ArrayList<>();
        }

        List<String> ans = new ArrayList<>();
        helper(root,"",ans);

        return ans;
        
    }
}