class Solution {
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] effort = new int[n][m];

        for(int i[] : effort)
        {
            Arrays.fill(i,Integer.MAX_VALUE);
        }

        effort[0][0] = 0;

        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);

        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty())
        {
            int[] curr = pq.remove();
            int row = curr[0];
            int col = curr[1];
            int currCost = curr[2];

            if(row == n-1 && col == m-1)
            {
                return currCost;
            }


            for(int d[] : dir){
                int newRow = row + d[0];
                int newCol = col + d[1];

                if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m)
                {
                    int srcHeight = heights[row][col];
                    int destHeight = heights[newRow][newCol];
                    int absDiff = Math.abs(srcHeight - destHeight);
                    int maxDiff = Math.max(absDiff,currCost);

                    if(maxDiff < effort[newRow][newCol])
                    {
                        effort[newRow][newCol] = maxDiff;
                        pq.add(new int[]{newRow,newCol,maxDiff});
                    }
                }
            }
        }

        return effort[n-1][m-1];
        
    }
}