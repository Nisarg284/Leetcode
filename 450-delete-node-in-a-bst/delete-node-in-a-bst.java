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

    public static TreeNode findPred(TreeNode root)
    {
        while(root.right!=null)
        {
            root=root.right;
        }

        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null)
        {
            return null;
        }

        if(root.val == key)
        {
            if(root.left == null && root.right == null)
            {
                return null;
            }

            if(root.left == null || root.right == null)
            {
                if(root.left == null)
                {
                    return root.right;
                }

                if(root.right == null)
                {
                    return root.left;
                }
            }

            if(root.left != null && root.right != null)
            {
                TreeNode pred = findPred(root.left);

                int rootVal = pred.val;
                pred.val = root.val;
                root.val = rootVal;
                 root.left = deleteNode(root.left,pred.val);
                 return root;
            }
        }

        if(root.val < key)
        {
           root.right =  deleteNode(root.right,key);
        }else{
            root.left = deleteNode(root.left,key);
        }

        return root;

        
    }
}