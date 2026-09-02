class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer,List<int[]>> graph = new HashMap<>();

        for(int[] node : times){

            int src = node[0];
            int dest = node[1];
            int time = node[2];

            graph.computeIfAbsent(src,j -> new ArrayList<>()).add(new int[]{dest,time});
        }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

            int[] distance = new int[n+1];

            Arrays.fill(distance,Integer.MAX_VALUE);

            boolean[] vis = new boolean[n+1];

            distance[k] = 0;
            pq.add(new int[]{k,0});

            while(!pq.isEmpty()){

                int[]srcInfo = pq.remove();
                int src = srcInfo[0];
                int currCost = srcInfo[1];

                if(vis[src]){
                    continue;
                }

                vis[src] = true;

                List<int[]> distNodes = graph.get(src);
                if(distNodes == null){
                    continue;
                }

                for(int[]destInfo : distNodes){

                    int dest = destInfo[0];
                    int pathCost = destInfo[1];

                    int newCost = currCost + pathCost;

                    if(newCost < distance[dest]){
                        distance[dest] = newCost;
                        pq.add(new int[]{dest,newCost});
                    }
                }
            }

            
            int minCost = Integer.MIN_VALUE;
            for(int i = 1;i<=n;i++){
                if(distance[i] == Integer.MAX_VALUE){
                    return -1;
                }
                minCost = Math.max(minCost,distance[i]);
            }

            return minCost;
        }
        
    }
