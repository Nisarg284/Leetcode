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
    public int findBottomLeftValue(TreeNode root) {

        if(root == null)
        {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode ans = null;

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr = q.remove();
                ans = curr;

                if(curr.right!=null)
                {
                    q.add(curr.right);
                }

                if(curr.left!=null)
                {
                    q.add(curr.left);
                }
            }
        }
        return ans.val;        
    }
}