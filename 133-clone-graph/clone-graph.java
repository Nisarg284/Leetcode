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
    public Node cloneGraph(Node node) {

        if(node == null)
        {
            return null;
        }


        HashMap<Node,Node> graph = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        // boolean[] vis = new boolean[101];

        graph.put(node,new Node(node.val));
        // vis[node.val] = true;

        q.add(node);

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0;i<size;i++)
            {
                Node curr = q.remove();
                Node copyNode = graph.get(curr);

                List<Node> neighbors = curr.neighbors;

                for(Node neighbor : neighbors)
                {
                    // copyNode.neighbors.add(new Node(neighbor.val));

                    if(!graph.containsKey(neighbor))
                    {
                        q.add(neighbor);
                        graph.put(neighbor,new Node(neighbor.val));
                    }

                    copyNode.neighbors.add(graph.get(neighbor));
                }
            }
        }


        return graph.get(node);




        
    }
}