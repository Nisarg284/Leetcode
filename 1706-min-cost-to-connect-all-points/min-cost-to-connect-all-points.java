class Solution {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        HashMap<Integer,List<int[]>> graph = new HashMap<>();

        for(int i = 0;i<n;i++){

            int src[] = points[i]; 
            int x1 = src[0];
            int y1 = src[1];
            int srcNode = i;
            for(int j = i+1;j<n;j++){

                int[]dest = points[j];
                int x2 = dest[0];
                int y2 = dest[1];
                int destNode = j;

                int cost = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                graph.computeIfAbsent(srcNode,key -> new ArrayList<>()).add(new int[]{destNode,cost});
                graph.computeIfAbsent(destNode,key -> new ArrayList<>()).add(new int[]{srcNode,cost});
            }
        }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
            pq.add(new int[]{0,0});
            int totalCost = 0;

            boolean[] vis = new boolean[n];
            int edgeCount = 0;

            while(!pq.isEmpty() && edgeCount < n)
            {

                int[] srcData = pq.remove();
                int src = srcData[0];
                int cost = srcData[1];

                if(vis[src]){
                    continue;
                }

                vis[src] = true;
                totalCost += cost;
                edgeCount++;

                List<int[]> destNodes = graph.get(src);
                if(destNodes == null){
                    continue;
                }

                for(int[] destNode : destNodes){
                    int dest = destNode[0];
                    int destCost = destNode[1];
                    if(!vis[dest]){
                        pq.add(destNode);
                    }
                }   
            }

            return totalCost;
        }             
    }




