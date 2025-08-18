class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        HashMap<Integer,List<int[]>> graph = new HashMap<>();

        for(int[] time : times)
        {
            int src = time[0];
            int dest = time[1];
            int cost = time[2];

            graph.computeIfAbsent(src, key -> new ArrayList<>()).add(new int[]{dest,cost});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);

        int[] distance = new int[n+1];

        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k] = 0;

        boolean[]vis = new boolean[n+1];

        pq.add(new int[]{k,0});

        while(!pq.isEmpty())
        {
            int[]srcInfo = pq.remove();
            int src = srcInfo[0];
            int currCost = srcInfo[1];

            if(vis[src])
            {
                continue;
            }
            vis[src] = true;

            

            // Extract it's connected nodes( neighbours)
            List<int[]> destNodes = graph.get(src);
            if(destNodes == null)
            {
                continue;
            }

            for(int[] destInfo : destNodes)
            {
                int dest = destInfo[0];
                int pathCost = destInfo[1];

                int newCost = currCost + pathCost;

                if(newCost < distance[dest])
                {
                    distance[dest] = newCost;
                    pq.add(new int[]{dest,newCost});
                }
            }
        }

        int minTime = Integer.MIN_VALUE;

        for(int i = 1;i<=n;i++)
        {
            if(distance[i] == Integer.MAX_VALUE)
            {
                return -1;
            }
            minTime = Math.max(minTime,distance[i]);
        }

        return minTime;
        
    }
}