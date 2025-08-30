class Solution {

    public int countPaths(int n, int[][] roads) {

        HashMap<Integer,List<long[]>> graph = new HashMap<>();

        for(int[] road : roads)
        {
            int src = road[0];
            int dest = road[1];
            int cost = road[2];

            graph.computeIfAbsent(src,key -> new ArrayList<>()).add(new long[]{dest,cost});
            graph.computeIfAbsent(dest,key -> new ArrayList<>()).add(new long[]{src,cost});
        }

        long[] dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);

        long[] ways = new long[n];
        
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]) );

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new long[]{0,0});
        int MOD = (int)1e9 + 7;

        while(!pq.isEmpty())
        {
            long[] curr = pq.remove();
            int src = (int)curr[0];
            long cost = curr[1];

             if (cost > dist[src])
             {
                continue;
             }
            
            List<long[]> destNodes = graph.get(src);
            if(destNodes == null)
            {
                continue;
            }

            for(long[] destData : destNodes)
            {
                int dest = (int)destData[0];
                long destCost = destData[1];
                long newCost = cost + destCost;

                if(dist[dest] > newCost)
                {
                    pq.add(new long[]{dest,newCost});
                    dist[dest] = newCost;
                    ways[dest] = ways[src];
                }else if(newCost == dist[dest])
                {
                    ways[dest]= (ways[dest]+ ways[src]) % MOD;
                }
            }

        }

        return (int) (ways[n-1] % MOD);

        
    }
}