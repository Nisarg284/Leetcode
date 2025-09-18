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

    public static void helper(TreeNode root,int level,List<Integer> ans)
    {
        if(root == null)
        {
            return;
        }

        ans.add(-1);

        ans.set(level,root.val);
        helper(root.left,level+1,ans);
        helper(root.right,level+1,ans);
        if(ans.get(level) == -1)
        {
            System.out.println("yes");
            ans.remove(level);
        }
    }
    public List<Integer> rightSideView(TreeNode root) {


        if(root == null)
        {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        int level = 0;

        helper(root,level,ans);

        while(ans.getLast() == -1)
        {
            ans.removeLast();
        }

        return ans;
        
    }
}