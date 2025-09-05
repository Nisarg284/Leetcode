class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        for(List<Integer> edge : connections)
        {
            int src = edge.get(0);
            int dest = edge.get(1);

            graph.computeIfAbsent(src,key -> new ArrayList<>()).add(dest); 
            graph.computeIfAbsent(dest,key -> new ArrayList<>()).add(src);
        }

        int[]disc = new int[n];
        int[] low = new int[n];

        Arrays.fill(disc,-1);
        int[] time = {0};

        List<List<Integer>> bridges = new ArrayList<>();

        for(int i = 0;i<n;i++)
        {
            if(disc[i] == -1)
            {
                tarjanDFS(i,-1,graph,disc,low,bridges,time);
            }
        }

        return bridges;
        
    }


    public static void tarjanDFS(int src,int parent,HashMap<Integer,List<Integer>>graph,int[]disc,int[]low,List<List<Integer>>bridges,int[]time)
    {
        disc[src] = low[src] = time[0]++;

        List<Integer> destNodes = graph.get(src);
        for(int dest : destNodes)
        {
            if(dest == parent)
            {
                continue;
            }

            if(disc[dest] == -1)
            {
                tarjanDFS(dest,src,graph,disc,low,bridges,time);
                low[src] = Math.min(low[src] , low[dest]);

                if(disc[src] < low[dest])
                {
                    List<Integer> ans = Arrays.asList(src,dest);
                    bridges.add(ans);
                }
            }else{
                low[src] = Math.min(low[src],disc[dest]);
            }
        }
    }
}