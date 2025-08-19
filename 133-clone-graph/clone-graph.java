/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public static void dfsHelper(Node original,HashMap<Node,Node> map)
    {
        List<Node> dest = original.neighbors;

        for(Node d:dest)
        {
            if(!map.containsKey(d))
            {
                Node newNode = new Node(d.val);
                map.put(d,new Node(d.val));
                dfsHelper(d,map);
                // map.get(original).neighbors.add(newNode);
            }
            map.get(original).neighbors.add(map.get(d));
        }
    }
    public Node cloneGraph(Node node) {

        if(node == null)
        {
            return null;
        }


        HashMap<Node,Node> map = new HashMap<>();

        map.put(node,new Node(node.val));

        dfsHelper(node,map);

        return map.get(node);
        
    }
}