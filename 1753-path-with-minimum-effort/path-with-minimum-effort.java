class Solution {

    // public static void helper(int row,int col,PriorityQueue<int[]>)
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] distance = new int[n][m];

        for(int i = 0;i<n;i++)
        {
            for(int j= 0;j<m;j++)
            {
                if( i== 0 && j == 0)
                {
                    continue;
                }

                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);

        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty())
        {
            int[] cellData = pq.remove();
            int row = cellData[0];
            int col = cellData[1];
            int srcHeight = cellData[2];

            if(row == n-1 && col == m-1)
            {
                return srcHeight;
            }

            for(int[] d : dir)
            {
                int newRow = row + d[0];
                int newCol = col + d[1];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m)
                {
                    int destHeight = heights[newRow][newCol];
                    int newDiff = Math.abs(heights[row][col] - destHeight);
                    int newHeight = Math.max(srcHeight,newDiff);

                    if( newHeight < distance[newRow][newCol])
                    {
                        distance[newRow][newCol] = newHeight;
                        pq.add(new int[]{newRow,newCol,newHeight});
                    }
                }
            }


        }

        return distance[n-1][m-1];

       



        
    }
}