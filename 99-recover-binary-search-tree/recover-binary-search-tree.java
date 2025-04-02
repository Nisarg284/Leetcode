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
    public void recoverTree(TreeNode root) {

        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode prevPrev = null;

        ArrayList<TreeNode> swap = new ArrayList<>();


        while(curr!=null)
        {
            if(curr.left != null)
            {
                TreeNode pred = curr.left;

                while(pred.right != null && pred.right != curr)
                {
                    pred = pred.right;
                }

                if(pred.right == null)
                {
                    pred.right = curr;
                    curr = curr.left;
                }

                if(pred.right == curr)
                {
                    pred.right = null;
                    if(prev != null && prevPrev != null)
                    {
                        if(prev.val > curr.val && prev.val > prevPrev.val)
                        {
                            swap.add(prev);
                        }else if(prev.val < curr.val  && prev.val < prevPrev.val)
                        {
                            swap.add(prev);
                        }
                    }
                    else if(prev!=null && prev.val > curr.val)
                    {
                        swap.add(prev);
                    }

                    prevPrev = prev;
                    prev = curr;
                    curr = curr.right;
                }
            }else
            {
                if(prev != null && prevPrev != null)
                    {
                        if(prev.val > curr.val && prev.val > prevPrev.val)
                        {
                            swap.add(prev);
                        }else if(prev.val < curr.val  && prev.val < prevPrev.val)
                        {
                            swap.add(prev);
                        }
                    }
                    else if(prev!=null && prev.val > curr.val)
                    {
                        swap.add(prev);
                    }

                prevPrev = prev;
                prev = curr;
                curr = curr.right;

            }
        }

        if(prevPrev.val > prev.val)
        {
            swap.add(prev);
        }
        
            TreeNode t1 = swap.get(0);
            TreeNode t2 = swap.get(swap.size()-1);

            int temp = t1.val;
            t1.val = t2.val;
            t2.val = temp;        
    }
}