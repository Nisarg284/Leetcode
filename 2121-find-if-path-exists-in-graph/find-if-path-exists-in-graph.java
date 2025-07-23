class Solution {

    public static boolean dfsHelper(HashMap<Integer,ArrayList<Integer>> graph,int src,boolean[]vis,int destination)
    {
        vis[src] = true;

        if(src == destination)
        {
            return true;
        }

        ArrayList<Integer> destNodes = graph.get(src);
        for(int dest : destNodes)
        {
            if(!vis[dest])
            {
                boolean flag = dfsHelper(graph,dest,vis,destination);
                if(flag)
                {
                    return true;
                }
            }
        }

        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();

        for(int[] i : edges)
        {
            int src = i[0];
            int dest = i[1];

            graph.computeIfAbsent(src,k->new ArrayList<>()).add(dest);
            graph.computeIfAbsent(dest,k->new ArrayList<>()).add(src);
        }

        boolean[] vis = new boolean[n];

        // for(int i = 0;i<n;i++)
        // {
        //     if(!vis[i])
        //     {
               boolean flag = dfsHelper(graph,source,vis,destination);

               if(flag)
               {
                return true;
               }
        //     }
        // }

        return false;


        
    }
}