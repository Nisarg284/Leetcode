class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        HashMap<Integer,List<int[]>> graph = new HashMap<>();

        for(int[] flight : flights){
            int currSrc = flight[0];
            int dest = flight[1];
            int cost = flight[2];

            graph.computeIfAbsent(currSrc,j -> new ArrayList<>()).add(new int[]{dest,cost});
        }

        k+=1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[2] - a[2]);

        int[]dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        pq.add(new int[]{src,0,k});

        while(!pq.isEmpty()){

            int[]srcNode = pq.remove();
            int currSrc = srcNode[0];
            int currCost = srcNode[1];
            int leftK = srcNode[2];


            List<int[]> destNode = graph.get(currSrc);
            if(destNode == null){
                continue;
            }

            for(int[]dest : destNode){
                int currDest = dest[0];
                int destCost = dest[1];
                int newLeftK = leftK - 1;
                int newCost =  currCost + destCost;

                if(newLeftK >= 0 && newCost < dist[currDest]){
                    pq.add(new int[]{currDest,newCost,newLeftK});
                    dist[currDest] = newCost;
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
        
    }
}