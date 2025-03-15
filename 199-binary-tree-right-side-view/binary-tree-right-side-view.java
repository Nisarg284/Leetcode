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
    public List<Integer> rightSideView(TreeNode root) {

        if(root == null)
        {
            return new ArrayList<>();
        }


        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        int level = 0;
        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i=0;i<size;i++)
            {
                TreeNode curr = q.remove();

                if( i == 0)
                {
                    ans.add(curr.val);
                }else{
                    ans.set(level,curr.val);
                }


                if(curr.left!=null)
                {
                    q.add(curr.left);
                }

                if(curr.right != null)
                {
                    q.add(curr.right);
                }
            }
            level++;
        }

        return ans;
        
    }
}