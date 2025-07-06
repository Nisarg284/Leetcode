class Solution {

    public static boolean dfsHelper(int src,int dest,HashMap<Integer,List<Integer>> graph,Set<Integer> vis)
    {
        if(src == dest)
        {
            return true;
        }

        vis.add(src);

        List<Integer> currAl = graph.get(src);
        for(int i = 0;i<currAl.size();i++)
        {
            if(!vis.contains(currAl.get(i)))
            {
                if(dfsHelper(currAl.get(i),dest,graph,vis))
                {
                    return true;
                }

            }
        }

        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        

        HashMap<Integer,List<Integer>> hm = new HashMap<>();

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

        // Normal Code

            // if(!hm.containsKey(u))
            // {
            //     List<Integer> al = new ArrayList<>();
            //     al.add(v);
            //     hm.put(u,al);
            // }else{
            //     List<Integer> al = hm.get(u);
            //     al.add(v);
            //     hm.put(u,al);
            // }

            // if(!hm.containsKey(v))
            // {
            //     List<Integer> al = new ArrayList<>();
            //     al.add(u);
            //     hm.put(v,al);
            // }else{
            //     List<Integer> al = hm.get(v);
            //     al.add(u);
            //     hm.put(v,al);
            // }

            // with lamda expression
            hm.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            hm.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }



        Set<Integer> vis = new HashSet<>();
        


        return dfsHelper(source,destination,hm,vis);
    }
}