class Solution {
    public int findCheapestPrice(int n, int[][] flights, int source, int dst, int k) {


        HashMap<Integer,List<int[]>> hm = new HashMap<>();

        for(int[] flight : flights)
        {
            int src = flight[0];
            int dest = flight[1];
            int cost = flight[2];
            hm.computeIfAbsent(src, key -> new ArrayList<>()).add(new int[]{dest,cost});
        }

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        k = k+1;
        dist[source] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[2] - a[2]);
        pq.add(new int[]{source,0,k});

        while(!pq.isEmpty())
        {
            int[] curr = pq.remove();
            int src = curr[0];
            int cost = curr[1];
            int leftK = curr[2];

            List<int[]> destData = hm.get(src);
            if(destData == null)
            {
                continue;
            }

            for(int[] destNodes : destData)
            {
                int dest = destNodes[0];
                int destCost = destNodes[1];
                int newK = leftK - 1;
                int newCost = cost + destCost;

                if(newK >= 0 && newCost < dist[dest])
                {
                    pq.add(new int[]{dest,newCost,newK});
                    dist[dest] = newCost;
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
        
    }
}