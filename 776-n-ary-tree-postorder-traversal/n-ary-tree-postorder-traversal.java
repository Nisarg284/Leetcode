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
}
*/

class Solution {

    public static void helper(Node root,List<Integer> post)
    {
        if(root == null)
        {
            return;
        }

        for(Node curr : root.children)
        {
            helper(curr,post);
        }

        post.add(root.val);
    }
    public List<Integer> postorder(Node root) {

        List<Integer> post = new ArrayList<>();

        helper(root,post);

        return post;
        
    }
}