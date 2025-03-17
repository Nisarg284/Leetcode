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


    public static void helper(TreeNode root,int targetSum,List<List<Integer>> ans,List<Integer> sub)
    {
        if(root == null)
        {
            return;
        }

        if(root.left == null && root.right == null && root.val == targetSum)
        {
            sub.add(root.val);
            ans.add(new ArrayList<>(sub));
            sub.removeLast();
            return;
        }
        sub.add(root.val);

        helper(root.left,targetSum - root.val,ans,sub);
        helper(root.right,targetSum - root.val,ans,sub);

        sub.removeLast();
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if(root == null)
        {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        helper(root,targetSum,ans,sub);
        // ans.add(sub);

        return ans;
        
    }
}