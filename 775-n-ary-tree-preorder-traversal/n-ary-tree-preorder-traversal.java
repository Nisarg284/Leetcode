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

    public static void helper(Node root,List<Integer> pre)
    {
        if(root == null)
        {
            return;
        }

        pre.add(root.val);

        for(Node curr : root.children)
        {
            helper(curr,pre);
        }
    }
    public List<Integer> preorder(Node root) {

        List<Integer> pre = new ArrayList<>();

        helper(root,pre);

        return pre;
        
    }
}