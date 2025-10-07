class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid[0][0] == 1)
        {
            return 0;
        }

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int dp[][] = new int[n][m];


        // int flag = true;
        for(int i = 0;i<n;i++)
        {
            if(obstacleGrid[i][0] != 1 )
            {
                dp[i][0] = 1;
            }else{
                break;
            }
        }

        // flag = true;

        for(int i = 0;i<m;i++)
        {
            if(obstacleGrid[0][i] != 1)
            {
                dp[0][i] = 1;
            }else{
                break;
            }
        }


        for(int[]arr : dp)
        {
            for(int i : arr)
            {
                System.out.print(i+" ");
            }
            System.out.println();
        }

        System.out.println("-----------------------");

        for(int i = 1;i<n;i++)
        {
            for(int j = 1;j<m;j++)
            {
                if(obstacleGrid[i][j] == 1)
                {
                    continue;
                }

                int top = dp[i-1][j];
                int left = dp[i][j-1];

                dp[i][j] = top + left;
            }
        }

        for(int[]arr : dp)
        {
            for(int i : arr)
            {
                System.out.print(i+" ");
            }
            System.out.println();
        }

        return dp[n-1][m-1];
        
    }
}