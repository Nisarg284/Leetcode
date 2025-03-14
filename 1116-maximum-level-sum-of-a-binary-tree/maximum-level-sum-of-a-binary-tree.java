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
    public int maxLevelSum(TreeNode root) {

        if(root == null)
        {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        int level = 1;
        int ansLevel = 1;

        int maxSum = Integer.MIN_VALUE;

        while(!q.isEmpty())
        {
            int size = q.size();
            int sum = 0;

            for(int i = 0;i<size;i++)
            {
                TreeNode temp = q.remove();
                sum += temp.val;

                if(temp.left!=null)
                {
                    q.add(temp.left);
                }

                if(temp.right!= null)
                {
                    q.add(temp.right);
                }
            }

            if(sum > maxSum)
            {
                maxSum = sum;
                ansLevel = level;
            }
            level++;
        }

        return ansLevel;
        
    }
}