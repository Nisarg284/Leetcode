class Solution {
    public int longestCycle(int[] edges) {

        int n = edges.length;
        

        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        HashMap<Integer,List<Integer>> reverseGraph = new HashMap<>();

        for(int i = 0;i<n;i++)
        {
            if(edges[i] != -1)
            {
                graph.computeIfAbsent(i,key -> new ArrayList<>()).add(edges[i]);
                reverseGraph.computeIfAbsent(edges[i],key -> new ArrayList<>()).add(i);
            }
           
        }


        boolean[] vis = new boolean[n];
        Stack<Integer> order = new Stack<>();

        for(int i = 0;i<n;i++)
        {
            if(!vis[i])
            {
                dfsHelper(i,graph,vis,order);
            }
        }


        Arrays.fill(vis,false);
        int count = Integer.MIN_VALUE;


        while(!order.isEmpty())
        {
            int src = order.pop();
            if(!vis[src])
            {
                int innerCounter = dfsHelper2(src,reverseGraph,vis);
                count = Math.max(innerCounter,count);
            }
        }

        return count == 1 ? -1 : count;


    }
    

    public static void dfsHelper(int src,HashMap<Integer,List<Integer>> graph,boolean[]vis,Stack<Integer>order)
    {
        vis[src] = true;

        if(graph.containsKey(src))
        {
            for(int dest : graph.get(src))
            {
                if(!vis[dest] )
                {
                    dfsHelper(dest,graph,vis,order);
                }
            }
        }

        order.push(src);
    }

    public static int dfsHelper2(int src,HashMap<Integer,List<Integer>>reverseGraph,boolean[]vis)
    {
        vis[src] = true;

        if(reverseGraph.containsKey(src))
        {
            for(int dest : reverseGraph.get(src))
            {
                if(!vis[dest])
                {
                    return 1 + dfsHelper2(dest,reverseGraph,vis);
                }   
            }
        }
        return 1;
    }


}