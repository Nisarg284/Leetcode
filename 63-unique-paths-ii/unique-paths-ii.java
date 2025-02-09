class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m][n];


        if(obstacleGrid[0][0] == 1)
        {
            return 0;
        }


        for(int i=0;i<m;i++)
        {
            int count =0;
            for(int j = 0;j<n;j++)
            {
                if( i == 0 || j==0)
                {
                    // if(obstacleGrid[i][j] == 1)
                    // {
                    //   dp[i][j] = 0;
                    //   count++;
                    //   if(count == n-1)
                    //   {
                    //     return 0;
                    //   }
                    // }else
                    // {
                    //     dp[i][j] = 1;
                    // }

                    if( i==0 && j==0)
                    {
                        dp[i][j] = 1;
                    }

                    if(obstacleGrid[0][j] != 1 && j != 0)
                    {
                        dp[i][j] = dp[0][j-1];
                    }

                    if(obstacleGrid[i][0]!= 1 && i != 0)
                    {
                        dp[i][j] = dp[i-1][0];
                    }
                        
                }
                else{
                    if(obstacleGrid[i][j] != 1)
                    {
                      dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
        }

        return dp[m-1][n-1];
        
    }
}