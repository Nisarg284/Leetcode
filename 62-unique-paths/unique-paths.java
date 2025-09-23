class Solution {

    public int helper(int row,int col,int[][]dp)
    {
        if(row < 0 || col < 0)
        {
            return 0;
        }

        if(row == 1 && col == 1)
        {
            return 1;
        }

        if(dp[row][col] != 0)
        {
            return dp[row][col];
        }

        return dp[row][col] =  helper(row-1,col,dp) + helper(row,col-1,dp);

    }
    public int uniquePaths(int row, int col) {

        int[][]dp = new int[row+1][col+1]; 
        return helper(row,col,dp);
        
    }
}