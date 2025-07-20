class Solution {

    public static void dfsHelper(HashMap<Integer,ArrayList<Integer>> graph,int src,HashSet<Integer> vis)
    {
        vis.add(src);

        ArrayList<Integer> destNodes = graph.get(src);
        if(destNodes == null)
        {
            return;
        }

        for(int dest : destNodes)
        {
            if(!vis.contains(dest))
            {
                dfsHelper(graph,dest,vis);
            }
        }
    }


    public static void bfsHelper(HashMap<Integer,ArrayList<Integer>> graph,int src,HashSet<Integer> vis)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis.add(src);


        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0;i<size;i++)
            {
                int currSrc = q.remove();

                ArrayList<Integer> destNodes = graph.get(currSrc);
                if(destNodes == null)
                {
                    continue;
                }

                for(int dest : destNodes)
                {
                    if(!vis.contains(dest))
                    {
                        q.add(dest);
                        vis.add(dest);
                    }
                }
            }
        }

    }

    public int findCircleNum(int[][] isConnected) {

        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();

        int n = isConnected.length;
        int m = isConnected[0].length;

        for(int i = 0;i<n;i++)
        {
            int src = i;
            for(int j = 0;j<m;j++)
            {
                int dest = j;

                if(isConnected[src][dest] == 1 && src != dest)
                {
                    graph.computeIfAbsent(src,k -> new ArrayList<>()).add(dest);
                }
            }
        }

        int count = 0;
        HashSet<Integer> vis = new HashSet<>();

        for(int i = 0;i<n;i++)
        {
            if(!vis.contains(i))
            {
                count++;
                bfsHelper(graph,i,vis);
                // dfsHelper(graph,i,vis);
            }
        }

        // System.out.println(graph);
        return count;
    }
}