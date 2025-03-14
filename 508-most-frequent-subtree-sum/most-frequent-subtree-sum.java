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

    public static int helper(TreeNode root,HashMap<Integer,Integer>hm)
    {
        if(root == null)
        {
            return 0;
        }

        int left = helper(root.left,hm);
        int right = helper(root.right,hm);

        int sum = root.val + left + right;
        hm.put(sum,hm.getOrDefault(sum,0)+1);

        return sum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {

        if(root == null)
        {
            return new int[0];
        }

        HashMap<Integer,Integer> hm = new HashMap<>();
        helper(root,hm);

        int maxFreq = 0;
        int maxNode = 0;

        ArrayList<Integer> res = new ArrayList<>();

        for(int i:hm.keySet())
        {
            int freq = hm.get(i);

            maxFreq = Math.max(maxFreq,freq);
        }

        for(int i: hm.keySet())
        {
            if(maxFreq == hm.get(i))
            {
                res.add(i);
            }
        }
        int[] ans = new int[res.size()];

        for(int i=0;i<res.size();i++)
        {
            ans[i] = res.get(i);
        }

        return ans;
    }
}