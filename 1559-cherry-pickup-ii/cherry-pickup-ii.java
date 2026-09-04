class Solution {

    public static int helper(int i,int j,int k,int[][]grid,int n,int m,Integer[][][]dp){

        if(i >= n || j < 0 || j >= m || k < 0 || k >= m){
            return Integer.MIN_VALUE;
        }

        if(dp[i][j][k] != null){
            return dp[i][j][k];
        }

        if(i == n-1){
            if(j == k){
                return grid[i][j];
            }
            return grid[i][j] + grid[i][k];
        }

        int totalCherries = Integer.MIN_VALUE;

        for(int col1 = -1;col1 <=1;col1++){
            for(int col2 = -1;col2 <= 1;col2++){
                int curr = 0;
                if(j == k){
                    curr = grid[i][j];
                }else{
                    curr = grid[i][j] + grid[i][k];
                }
                totalCherries = Math.max(totalCherries , curr + helper(i+1,j + col1,k + col2,grid,n,m,dp));
            }
        }
        
        return dp[i][j][k] = totalCherries;
    }
    public int cherryPickup(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int i = 0;
        int j = 0;
        int k = m - 1;

        Integer[][][]dp = new Integer[n][m][m];

        return helper(i,j,k,grid,n,m,dp);
        
    }
}