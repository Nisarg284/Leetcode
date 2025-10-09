class Solution {

    public static int helper(int row,int rob1,int rob2,int[][]grid,int n,int m,int[][][] dp)
    {
        if(rob1 < 0 || rob1 >= m || rob2 < 0 || rob2 >= m)
        {
            return Integer.MIN_VALUE;
            // return 0;
        }

        if(row == n-1)
        {
            if(rob1 == rob2)
            {
                return grid[row][rob1];
            }else{
                return grid[row][rob1] + grid[row][rob2];
            }
        }

        if(dp[row][rob1][rob2] != Integer.MIN_VALUE)
        {
            return dp[row][rob1][rob2];
        }

        int currMax = Integer.MIN_VALUE;

        for(int i = -1;i<=1;i++)
        {
            for(int j = -1;j<=1;j++)
            {
                int currCherries = 0;
                if(rob1 == rob2)
                {
                    currCherries = grid[row][rob1];
                }else{
                    currCherries = grid[row][rob1] + grid[row][rob2];
                }

                currMax = Math.max(currMax, currCherries + helper(row+1,rob1 + i,rob2 + j,grid,n,m,dp));
            }
        }

        return dp[row][rob1][rob2] = currMax;
    }
    public int cherryPickup(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        for(int[][]mat : dp)
        {
            for(int[]arr : mat)
            {
                Arrays.fill(arr,Integer.MIN_VALUE);
            }
        }

        return helper(0,0,m-1,grid,n,m,dp);
        
    }
}