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

    public static void helper(TreeNode root,List<Integer> al)
    {
        if(root == null)
        {
            return;
        }

        helper(root.left,al);
        al.add(root.val);
        helper(root.right,al);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> al1 = new ArrayList<>();

        helper(root1,al1);

        List<Integer> al2 = new ArrayList<>();
        helper(root2,al2);

        int i = 0;
        int j = 0;

        List<Integer> ans = new ArrayList<>();
        
        while( i < al1.size() && j < al2.size())
        {
            if(al1.get(i) <= al2.get(j))
            {
                ans.add(al1.get(i));
                i++;
            }else{
                ans.add(al2.get(j));
                j++;
            }
        }

        while(i < al1.size())
        {
            ans.add(al1.get(i));
            i++;
        }

        while(j < al2.size())
        {
            ans.add(al2.get(j));
            j++;
        }

        return ans; 
    }
}