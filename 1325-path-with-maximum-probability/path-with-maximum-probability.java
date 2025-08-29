class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        HashMap<Integer,List<int[]>> hm = new HashMap<>();

        for(int i = 0;i<edges.length;i++)
        {
            int src = edges[i][0];
            int dest = edges[i][1];
            int succIdx = i;

            hm.computeIfAbsent(src,key -> new ArrayList<>()).add(new int[]{dest,succIdx});
            hm.computeIfAbsent(dest,key -> new ArrayList<>()).add(new int[]{src,succIdx});
        }

        // for(int key : hm.keySet())
        // {
        //     List<int[]> destNodes = hm.get(key);
        //     for(int i = 0;i<destNodes.size();i++)
        //     {
        //         int[] data = destNodes.get(i);
        //         System.out.println(STR."src : \{key} -> dest: \{data[0]} , idx : \{data[1]}");
        //     }
        // }


         double[] dist = new double[n];

        dist[start] = 1d;

        // PriorityQueue<double[]> pq = new PriorityQueue<>(Double.compare(b[1],a[1]));
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));

        pq.add(new double[]{start,dist[start]});

        while(!pq.isEmpty())
        {
            double[] curr = pq.remove();
            int src = (int) curr[0];
            double cost = curr[1];

            if(src == end)
            {
                return cost;
            }

            List<int[]> destNodes = hm.get(src);
            if(destNodes == null)
            {
                continue;
            }
            
            for(int[] dest : destNodes)
            {
                int destination = dest[0];
                int succIdx = dest[1];
                double newCost = cost * succProb[succIdx];

                if(dist[destination] < newCost)
                {
                    dist[destination] = newCost;
                    pq.add(new double[]{destination,newCost});
                }
            }

        }

        return dist[end];
        
        
    }
}