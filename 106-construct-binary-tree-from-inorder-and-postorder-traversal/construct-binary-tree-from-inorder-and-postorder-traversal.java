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

    public static TreeNode helper(int[] in,int il,int ih, int[] post,int pl,int ph,HashMap<Integer,Integer> hm)
    {
        if(pl > ph)
        {
            return null;
        }

        int val = post[ph];
        TreeNode root = new TreeNode(val);

        int rootIdx = hm.get(val);
        int size = rootIdx - il;

        root.left = helper(in,il,rootIdx - 1,post,pl,pl+size - 1,hm);
        root.right = helper(in,rootIdx+1,ih,post,pl+size,ph-1,hm);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Define HashMap
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = inorder.length;

        for(int i = 0;i<n;i++)
        {
            hm.put(inorder[i],i);
        }

        return helper(inorder,0,n-1,postorder,0,n-1,hm);
    }
}