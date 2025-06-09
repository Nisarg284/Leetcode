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


    public static boolean isPalindrome(HashMap<Integer,Integer> hm)
    {
        if(hm.size() == 1)
        {
            return true;
        }

        // System.out.println(hm);

        int oddCount = 0;

        for(int freq : hm.keySet())
        {
            // System.out.println(freq);
            if(hm.get(freq) % 2 != 0)
            {
                oddCount++;
            }
        }

        return oddCount < 2 ? true : false;
    }

    public static int findPath(TreeNode root,HashMap<Integer,Integer> hm,int[]ans)
    {
        if(root == null)
        {
            return 0;
        }

        hm.put(root.val,hm.getOrDefault(root.val,0)+1);


        if(root.left == null && root.right == null)
        {

            boolean isCheck = isPalindrome(hm);

            // if(isCheck)
            // {
            //     ans[0]++;
            // }
            if(hm.get(root.val) == 1)
            {
                hm.remove(root.val);
            }else{
                hm.put(root.val,hm.get(root.val)-1);
            }

            if(isCheck)
            {
                return 1;
            }else{
                return 0;
            }

            // return;
        }


        // System.out.println(hm);

        int left = findPath(root.left,hm,ans);
        int right = findPath(root.right,hm,ans);

        // findPath(root.left,hm,ans);
        // findPath(root.right,hm,ans);

        if(hm.get(root.val) == 1)
            {
                hm.remove(root.val);
            }else{
                hm.put(root.val,hm.get(root.val)-1);
            }

        // if(hm.get(root.val) == 1)
        //     {
        //         hm.remove(root.val);
        //     }else{
        //         hm.put(root.val,hm.get(root.val)-1);
        //     }

        return left + right;
    }
    public int pseudoPalindromicPaths (TreeNode root) {

        HashMap<Integer,Integer> hm = new HashMap<>();

        

        int[] ans = new int[1];

        findPath(root,hm,ans);

        // return ans[0];

        return findPath(root,hm,ans);

        
    }
}