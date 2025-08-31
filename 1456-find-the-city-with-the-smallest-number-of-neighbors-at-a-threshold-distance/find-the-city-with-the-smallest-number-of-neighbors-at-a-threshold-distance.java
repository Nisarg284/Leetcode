class Solution {

    public static int[] dijkstrasAlgo(int source,HashMap<Integer,List<int[]>> graph,int dt,int n)
    {
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        dist[source] = 0;
        pq.add(new int[]{source,0});

        while(!pq.isEmpty())
        {
            int[] curr = pq.remove();
            int src = curr[0];
            int cost = curr[1];

            if(cost > dist[src] || !graph.containsKey(src))
            {
                continue;
            }

            List<int[]> destNodes = graph.get(src);

            for(int[] destData : destNodes)
            {
                int dest = destData[0];
                int edgeCost = destData[1];
                int newCost = cost + edgeCost;

                if(newCost < dist[dest])
                {
                    pq.add(new int[]{dest,newCost});
                    dist[dest] = newCost;
                }
            }
        }

        for(int i : dist)
        {
            System.out.print(i+" ");
        }
        System.out.println();
        // dist[source] = -1;

        // count city distance  <= dt
        int count = (int)Arrays.stream(dist)
                                .filter(i -> i <= dt && i != 0)
                                .count();

        System.out.println(count);

        
        int[] data = {count,source};
        return data;

    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {


        HashMap<Integer,List<int[]>> graph = new HashMap<>();

        for(int[] edge : edges)
        {
            int src = edge[0];
            int dest = edge[1];
            int cost = edge[2];

            graph.computeIfAbsent(src,key -> new ArrayList<>()).add(new int[]{dest,cost});
            graph.computeIfAbsent(dest,key -> new ArrayList<>()).add(new int[]{src,cost});
        }


        int minCityCount = n;
        int city = -1;

        
        for(int i = 0;i<n;i++)
        {
            int[] cityData = dijkstrasAlgo(i,graph,distanceThreshold,n);
            int currMinCityCount = cityData[0];
            int newCity = cityData[1];

            if(minCityCount >= currMinCityCount)
            {
                System.out.println("Yes");
                minCityCount = currMinCityCount;
                city = newCity;
            }
        }


        return city;
        
    }
}