class Solution {
    public int swimInWater(int[][] grid) {


        int n = grid.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);

        pq.add(new int[]{0,0,grid[0][0]});

        int[][] dist = new int[n][n];

        for(int[] d: dist)
        {
            Arrays.fill(d,Integer.MAX_VALUE);
        }

        dist[0][0] = grid[0][0];
        // int ans  = grid[];

        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

        while(!pq.isEmpty())
        {
            int[] curr = pq.remove();
            int row = curr[0];
            int col = curr[1];
            int height = curr[2];
            grid[row][col] = -1;

            if(row == n-1 && col == n-1)
            {
                return height;
            }

            // ans = Math.max(ans,height);

            for(int[] d : dir)
            {
                int newRow = row + d[0];
                int newCol = col + d[1];
                
                if(newRow < n && newCol < n && newCol >= 0 && newRow >= 0 && grid[newRow][newCol] != -1)
                {
                    int newHeight = grid[newRow][newCol];
                    int maxHeight = Math.max(height,newHeight);
                    System.out.println("height: "+ height + ", newHeight: "+newHeight);
                    dist[newRow][newCol] = maxHeight;
                    pq.add(new int[]{newRow,newCol,maxHeight});
                }

            }
        }

        return dist[n-1][n-1];
        
    }
}