/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public static TreeNode helper(int[] preorder, int pl, int ph, int[] inorder, int il, int ih,
            HashMap<Integer, Integer> inorderMap) {

                if(pl>ph)
                {
                    return null;
                }



                int val = preorder[pl];
                TreeNode root = new TreeNode(val);

                int i = inorderMap.get(val);

                int size = i - il;

                root.left = helper(preorder,pl+1,pl+size,inorder,il,i-1,inorderMap);
                root.right = helper(preorder,pl+size+1,ph,inorder,i+1,ih,inorderMap);

                return root;


    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        int n = preorder.length;

        return helper(preorder, 0, n - 1, inorder, 0, n - 1, inorderMap);
    }
}