class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if(n==1)
        {
            result.add(0);
            return result;
        }

        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n];

        for(int[] edge : edges)
        {
            int src = edge[0];
            int dest = edge[1];

            graph.computeIfAbsent(src,key -> new ArrayList<>()).add(dest);
            graph.computeIfAbsent(dest,key -> new ArrayList<>()).add(src);

            inDegree[src]++;
            inDegree[dest]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<inDegree.length;i++)
        {
            if(inDegree[i] == 1)
            {
                q.add(i);
            }
        }


        int count = n;

        while( count > 2)
        {
            int size = q.size();
            count -= size;

            for(int i = 0;i<size;i++)
            {
                int src = q.remove();
                // count--;

                List<Integer> destNodes = graph.get(src);
                if(destNodes == null)
                {
                    continue;
                } 

                for(int dest : destNodes)
                {
                    inDegree[dest]--;
                    if(inDegree[dest] == 1)
                    {
                        q.add(dest);
                    }
                }
            }
        }

        // List<Integer> result = new ArrayList<>();

        while(!q.isEmpty())
        {
            result.add(q.remove());
        }

        return result;
        
    }
}