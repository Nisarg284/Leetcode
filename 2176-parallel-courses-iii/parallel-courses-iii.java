class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {


        HashMap<Integer,List<Integer>> graph = new HashMap<>();

        int[] inDegree = new int[n+1];
        int[] dp = new int[n+1];

        for(int[] rel : relations)
        {
            int src = rel[0];
            int dest = rel[1];

            graph.computeIfAbsent(src,key -> new ArrayList<>()).add(dest);
            inDegree[dest]++;
        }

        Queue<int[]> q = new LinkedList<>();

        for(int i = 1;i<=n;i++)
        {
            System.out.print("src : "+i+" degree : "+inDegree[i]+ " , ");
            if(inDegree[i] == 0)
            {
                q.add(new int[]{i,time[i-1]});
            }
            dp[i] = time[i-1];
        }
        System.out.println();

        // int maxTime = 0;

        while(!q.isEmpty())
        {
            int size = q.size();
            // int currMax = 0;
            for(int i = 0;i<size;i++)
            {
                int[] srcInfo = q.remove();
                int src = srcInfo[0];
                int val = srcInfo[1];

                // currMax = Math.max(currMax,val);
                // dp[src] = dp[src-1] + val
                // System.out.println("src : "+ src + ", val : "+val +" , currMax : "+currMax);
                
                List<Integer> destNodes = graph.get(src);
                if(destNodes == null)
                {
                    continue;
                }

                for(int dest : destNodes)
                {
                    dp[dest] = Math.max(dp[dest], dp[src] + time[dest-1]);
                    inDegree[dest]--;
                    if(inDegree[dest] == 0)
                    {
                        q.add(new int[]{dest,time[dest-1]});
                    }
                }
            }

            // maxTime+= currMax; 
        }

        int maxTime = 0;

        for(int i = 1;i<=n;i++)
        {
            maxTime = Math.max(dp[i],maxTime);
        }


        return maxTime;

        
    }
}