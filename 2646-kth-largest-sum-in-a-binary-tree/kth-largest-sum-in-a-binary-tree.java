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
    public long kthLargestLevelSum(TreeNode root, int k) {

        if(root == null)
        {
            return -1;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        PriorityQueue<Long> pq = new PriorityQueue<>();

        int level = 0;


        while(!q.isEmpty())
        {
            int size = q.size();
            long sum = 0;

            for(int i=0;i<size;i++)
            {
                TreeNode temp = q.remove();

                sum += temp.val;

                if(temp.left!= null)
                {
                    q.add(temp.left);
                }

                if(temp.right!= null)
                {
                    q.add(temp.right);
                }
            }

            pq.add(sum);
            if(pq.size() > k)
            {
                pq.remove();
            }
            level++;
        }

        if(level < k)
        {
            return -1;
        }

        return pq.peek();
        
    }
}