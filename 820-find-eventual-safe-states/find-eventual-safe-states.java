class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();

        int[] inDegree = new int[n];

        for(int i = 0;i<n;i++)
        {
            int[] neighbours = graph[i];
            int dest = i;

            for(int src : neighbours)
            {
                inDegree[dest]++;
                adj.computeIfAbsent(src,k->new ArrayList<>()).add(dest);
            }
        }

        // System.out.println(adj);
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<inDegree.length;i++)
        {
            if(inDegree[i] == 0)
            {
                q.add(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0;i<size;i++)
            {
                int src = q.remove();
                safeNodes.add(src);

                ArrayList<Integer> destNodes = adj.get(src);
                if(destNodes == null)
                {
                    continue;
                }

                for(int dest : destNodes)
                {
                    inDegree[dest]--;
                    if(inDegree[dest] == 0)
                    {
                        q.add(dest);
                    }
                }
            }
        }

        safeNodes.sort((a,b)-> a - b);

        return safeNodes;
        
    }
}