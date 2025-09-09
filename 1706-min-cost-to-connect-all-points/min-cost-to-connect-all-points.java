class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
       
       HashMap<Character,List<Pair>> graph = new HashMap<>();

       for(int i = 0;i<n-1;i++)
       {
            int x1 = points[i][0];
            int y1 = points[i][1];
            char src = (char) ('a'+i);
            for(int j = i+1;j<n;j++)
            {
                int x2 = points[j][0];
                int y2 = points[j][1];

                char dest = (char) ('a'+j);
                int cost = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                // System.out.println(STR."\{src} ----- \{dest} , cost : \{cost}");
                graph.computeIfAbsent(src,key -> new ArrayList<>()).add(new Pair(dest,cost));
                graph.computeIfAbsent(dest,key -> new ArrayList<>()).add(new Pair(src,cost));

            }
       }

       PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
       pq.add(new Pair('a',0));

       int totalCost = 0;
       Set<Character> vis = new HashSet<>();

        int edgeCount = 0;
       while(!pq.isEmpty() && edgeCount < n)
       {
            Pair srcData = pq.remove();
            char src = srcData.src;
            int cost = srcData.cost;

            if(vis.contains(src))
            {
                continue;
            }
            totalCost += cost;
            vis.add(src);
            edgeCount++;

            if(graph.containsKey(src))
            {
                for(Pair destNode : graph.get(src))
                {
                    char dest = destNode.src;
                    if(!vis.contains(dest))
                    {
                        pq.add(destNode);
                    }
                }
            }
       }

       return totalCost;
        
    }
}

class Pair{
    char src;
    int cost;

    public Pair(char src,int cost)
    {
        this.src = src;
        this.cost = cost;
    }
}