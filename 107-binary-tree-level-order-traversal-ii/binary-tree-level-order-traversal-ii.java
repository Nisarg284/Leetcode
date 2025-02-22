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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if(root == null)
        {
            return new ArrayList<>();
        }

        // Define Queue of TreeNode
        Queue<TreeNode> q = new LinkedList<>();

        List<List<Integer>> ans = new ArrayList<>();

        q.add(root);

        while(!q.isEmpty())
        {
            int levelSize = q.size();
            List<Integer> al = new ArrayList<>();
            for(int i=0;i<levelSize;i++)
            {
                TreeNode temp = q.remove();
                al.add(temp.val);

                if(temp.left!=null)
                {
                    q.add(temp.left);
                }

                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
            }
            ans.add(al);
        }

        Collections.reverse(ans);
        return ans;
        
    }
}