class Solution {

    public static int helper(int row,int col,int[][]dp,int[][]grid)
    {
        if(row < 0 || col < 0)
        {
            return Integer.MAX_VALUE;
        }

        if(row == 0 && col == 0)
        {
            return grid[0][0];
        }

        if(dp[row][col] != -1)
        {
            return dp[row][col];
        }

        int left = helper(row-1,col,dp,grid);
        int top = helper(row,col-1,dp,grid);

        // int dp[row][col] = Math.min(left,top);

        return dp[row][col] =grid[row][col] + Math.min(left,top);
    }
    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[n][m];
        for(int[]d : dp)
        {
            Arrays.fill(d,-1);
        }

        int row = n-1;
        int col = m-1;

        return helper(row,col,dp,grid);
    }
}


