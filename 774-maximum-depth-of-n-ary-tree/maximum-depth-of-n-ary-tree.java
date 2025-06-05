/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    public static void helper(Node root,int[]ans,int currDep)
    {
        if(root == null)
        {
            return;
        }

        for(Node curr : root.children)
        {
            helper(curr , ans , currDep + 1);
        }

        ans[0] = Math.max(ans[0],currDep);
        return;


    }
    public int maxDepth(Node root) {

        if(root == null)
        {
            return 0;
        }



        int currDep = 0;
        int[] ans = new int[1];
        helper(root,ans,currDep);
        return ans[0]+1;




    }
}