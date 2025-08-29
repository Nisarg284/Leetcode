class Solution {

    public static void bfsHelper(List<List<Integer>> grid,int[][]dist,int[][]dir,int n)
    {
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(grid.get(i).get(j) == 1)
                {
                    q.add(new int[]{i,j});
                    dist[i][j] = 0;
                }
            }
        }


        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i = 0;i<size;i++)
            {
                int[] curr = q.remove();
                int row = curr[0];
                int col = curr[1];
                int cost = dist[row][col];

                for(int[] d : dir)
                {
                    int newRow = row + d[0];
                    int newCol = col + d[1];

                    if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && dist[newRow][newCol] > cost + 1)
                    {
                        dist[newRow][newCol] = cost + 1;
                        q.add(new int[]{newRow,newCol});
                    }
                }
            }
        }
    }


    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();
        // if start == 1 ( left top corner) or last cell is 1 then return 0
        if(grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1)
        {
            return 0;
        }

        int[][] dist = new int[n][n];
        for(int i[] : dist)
        {
            Arrays.fill(i,Integer.MAX_VALUE);
        }

        // direction array
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        
        // call bfs to fill score array
        bfsHelper(grid,dist,dir,n);

        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[2] - a[2]);
        pq.add(new int[]{0,0,dist[0][0]});


        while(!pq.isEmpty())
        {
            int[] curr = pq.remove();
            int row = curr[0];
            int col = curr[1];
            int cost = curr[2];

            if(row == n-1 && col == n-1)
            {
                return cost;
            }
            // vis[row][col] = true;

            for(int[] d : dir)
            {
                int newRow = row + d[0];
                int newCol = col + d[1];
                
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !vis[newRow][newCol]){

                    int newCost = Math.min(cost,dist[newRow][newCol]);
                    pq.add(new int[]{newRow,newCol,newCost});
                    vis[newRow][newCol] = true;
                }
            }
        }


        return dist[n-1][n-1];



        
    }
}