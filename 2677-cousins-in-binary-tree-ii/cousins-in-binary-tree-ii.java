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
    public TreeNode replaceValueInTree(TreeNode root) {

        if(root == null)
        {
            return null;
        }


        Queue<TreeNode> q = new LinkedList<>();
        HashMap<Integer,Integer> levelSum = new HashMap<>();

        int level = 0;
        q.add(root);

        while(!q.isEmpty())
        {
            int sum = 0;
            int size = q.size();

            for(int i=0;i<size;i++)
            {
                TreeNode temp = q.remove();
                sum += temp.val;

                if(temp.left != null)
                {
                    q.add(temp.left);  
                }

                if(temp.right != null)
                {
                    q.add(temp.right);  
                }
            }
            levelSum.put(level,sum);
            level++;
        }


        level = 0;
        q.add(root);

        root.val = 0;

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i=0;i<size;i++)
            {
                TreeNode temp = q.remove();
                int sibSum = 0;

                if(temp.left!=null)
                {
                    q.add(temp.left);
                    sibSum+=temp.left.val;
                }

                if(temp.right!=null)
                {
                    q.add(temp.right);
                    sibSum+=temp.right.val;
                }

                if(temp.left!=null)
                {
                    temp.left.val = levelSum.get(level+1) - sibSum;
                }

                if(temp.right!=null)
                {
                    temp.right.val = levelSum.get(level+1) - sibSum;
                }
            }
            level++;
        }

        return root;
        
    }
}