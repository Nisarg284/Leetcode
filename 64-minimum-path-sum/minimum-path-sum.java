class Solution {
    public int minPathSum(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        int[][]dp = new int[n][m];
        dp[0][0] = grid[0][0];

        // for first col
        for(int i = 1;i<n;i++)
        {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }

        // for first row
        for(int i = 1;i<m;i++)
        {
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }

        // for(int arr[] : dp)
        // {
        //     for(int i: arr)
        //     {
        //         System.out.print(i+" ");
        //     }
        //     System.out.println();
        // }

        // System.out.println("------------------------");


        for(int i = 1;i<n;i++)
        {
            for(int j = 1;j<m;j++)
            {
                int top = dp[i-1][j];
                int left = dp[i][j-1];

                dp[i][j] = grid[i][j] + Math.min(top,left);
            }
        }


        // for(int arr[] : dp)
        // {
        //     for(int i: arr)
        //     {
        //         System.out.print(i+" ");
        //     }
        //     System.out.println();
        // }

        return dp[n-1][m-1];

        
        
    }
}