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
    public boolean isEvenOddTree(TreeNode root) {

        if(root == null)
        {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;

        while(!q.isEmpty())
        {
            int size = q.size();

            int prevVal = Integer.MAX_VALUE;
            if(level % 2 == 0)
            {
                prevVal = Integer.MIN_VALUE;
            }
            for(int i =0;i<size;i++)
            {
                TreeNode curr = q.remove();
                int currVal = curr.val;
                if(level%2==0)
                {
                    if(currVal % 2 ==0 || currVal<=prevVal)
                    {
                        return false;
                    }
                }
                else{
                    if(currVal % 2 != 0 || currVal >= prevVal)
                    {
                        return false;
                    }
                }

                if(curr.left!=null)
                {
                    q.add(curr.left);
                }

                if(curr.right!=null)
                {
                    q.add(curr.right);
                }

                prevVal = curr.val;
            }
            level++;
        }

        return true;
        
    }
}