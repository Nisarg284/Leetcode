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
    public List<List<Integer>> levelOrder(Node root) {

        if(root == null)
        {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.add(root);


        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> subRes = new ArrayList<>();

            for(int i = 0;i<size;i++)
            {
                Node curr = q.remove();
                subRes.add(curr.val);
                List<Node> currList = curr.children;
                for(Node currNode : currList)
                {
                    q.add(currNode);
                }
            }
            res.add(subRes);
        }

        return res;
        
    }
}