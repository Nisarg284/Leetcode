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
    public List<List<Integer>> levelOrder(TreeNode root) {


        if(root == null)
        {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> al = new ArrayList<>();
            for(int i = 0;i<size;i++)
            {
                TreeNode curr = q.remove();
                al.add(curr.val);

                if(curr.left != null)
                {
                    q.add(curr.left);
                }

                if(curr.right != null)
                {
                    q.add(curr.right);
                }
            }

            ans.add(al);
        }

        return ans;
        
    }
}