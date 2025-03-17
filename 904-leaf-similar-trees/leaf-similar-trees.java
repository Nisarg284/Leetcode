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

    public static void filling(TreeNode root,ArrayList<Integer> li)
    {
        if(root == null)
        {
            return;
        }

        // leaf node condition
        if(root.left == null && root.right == null)
        {
            li.add(root.val);
            return;
        }

        filling(root.left,li);
        filling(root.right,li);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        if(root1 == null || root2 == null)
        {
            return false;
        }

        ArrayList<Integer> li1 = new ArrayList<>();
        ArrayList<Integer> li2 = new ArrayList<>();
        filling(root1,li1);
        filling(root2,li2);

        return li1.equals(li2);

        
    }
}