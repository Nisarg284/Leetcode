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
    public boolean isCousins(TreeNode root, int x, int y) {

        if(root == null)
        {
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();

        // HashSet<Integer> hs = new HashSet<>();
        // hs.add(x);
        // hs.add(y);

        q.add(root);

        int xDepth = -1;
        int yDepth = -1;

        TreeNode xParent = null;
        TreeNode yParent = null;
        int level = 0;

        while(!q.isEmpty())
        {
            int size = q.size();
            // HashSet<Integer> hs = new HashSet<>();
            // hs.add(x);
            // hs.add(y);

            for(int i=0;i<size;i++)
            {
                TreeNode temp = q.remove();
                // if(hs.contains(temp.val))
                // {
                //     hs.remove(temp.val);
                // }

                // if(hs.isEmpty() && level > 2)
                // {
                //     return true;
                // }

                if(temp.left!=null){
                    q.add(temp.left);

                    if(temp.left.val == x)
                    {
                        xParent = temp;
                        xDepth = level+1;
                    }


                    if(temp.left.val == y)
                    {
                        yParent = temp;
                        yDepth = level+1;
                    }
                }

                if(temp.right!=null){
                    q.add(temp.right);

                    if(temp.right.val == x)
                    {
                        xParent = temp;
                        xDepth = level+1;
                    }


                    if(temp.right.val == y)
                    {
                        yParent = temp;
                        yDepth = level+1;
                    }
                }
            }
            level++;
        }
        return xDepth == yDepth && xParent != yParent;
    }
}