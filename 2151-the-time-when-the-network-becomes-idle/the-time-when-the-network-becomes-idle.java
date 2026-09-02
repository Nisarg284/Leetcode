class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        
        Map<Integer,List<Integer>> graph = new HashMap<>();

        for(int[]edge : edges){
            int src = edge[0];
            int dest = edge[1];

            graph.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
            graph.computeIfAbsent(dest, k -> new ArrayList<>()).add(src);
        }

        int n = patience.length;
        // System.out.println(graph);
        int[]distance = new int[n];

        Arrays.fill(distance,-1);

        Queue<Integer> q = new LinkedList<>();

        distance[0] = 0;
        q.add(0);
        int count = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0;i<size;i++){
                int src = q.remove();
                // distance[src] = count;

                List<Integer> destNodes = graph.get(src);
                if(destNodes == null){
                    continue;
                }

                for(int dest : destNodes){
                    if(distance[dest] == -1){
                        distance[dest] = distance[src] + 1;
                        q.add(dest);
                    }
                }

            }
            // count++;
        }


        int ans = 0;

        for(int i = 1;i<n;i++){
            System.out.print(distance[i] + " ");
            int roundTrip = 2 * distance[i];

            int lastSend = ((roundTrip - 1) / patience[i]) * patience[i];

            int serverIdle = roundTrip + lastSend + 1;

            ans = Math.max(serverIdle,ans);
        }

        return ans;




        // return 0;
    }
}