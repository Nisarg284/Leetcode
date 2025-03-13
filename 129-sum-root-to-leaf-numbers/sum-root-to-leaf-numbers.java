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

    public static void helper(TreeNode root,int sum,ArrayList<Integer>ans)
    {
        if(root == null)
        {
            return;
        }

        if(root.left == null && root.right == null)
        {
            ans.add(sum * 10 + root.val);
            return;
        }

        // if(root.left == null)
        // {
        //     ans.add(sum + root.val);
        // }else if(root.right == null)
        // {
        //     ans.add(sum + root.val);
        // }

        helper(root.left,sum*10 + root.val,ans);
        helper(root.right,sum * 10 +root.val,ans);

    }
    public int sumNumbers(TreeNode root) {

        if(root == null)
        {
            return 0;
        }

        int sum = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        helper(root,sum,ans);

        int result = 0;

        for(int i:ans)
        {
            result+= i;
        }



        return result;
          
        
    }
}