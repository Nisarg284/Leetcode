class Solution {
    public int minimumObstacles(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        int[][] minCost = new int[n][m];

        for(int[] arr : minCost)
        {
            Arrays.fill(arr,Integer.MAX_VALUE);
        }

        minCost[0][0] = grid[0][0];

        pq.add(new int[]{0,0,minCost[0][0]});
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

        while(!pq.isEmpty())
        {
            int[] curr = pq.remove();
            int row = curr[0];
            int col = curr[1];
            int cost = curr[2];

            if(row == n-1 && col == m-1)
            {
                return cost;
            }

            for(int[] d : dir)
            {
                int newRow = row + d[0];
                int newCol = col + d[1];

                if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && minCost[newRow][newCol] > cost + grid[newRow][newCol])
                {
                    int newCost = cost + grid[newRow][newCol];
                    pq.add(new int[]{newRow,newCol,newCost});
                    minCost[newRow][newCol] = newCost;
                }
            }
        }

        return minCost[n-1][m-1];
        
    }
}