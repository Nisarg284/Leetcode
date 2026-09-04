class Solution {

    public static int helper(int i,int j,int[][]grid,int k,int n,int m,int[][][]dp){

        if(i >= n || j >= m){
            return -1;
        }


        if(dp[i][j][k] != Integer.MIN_VALUE){
            return dp[i][j][k];
        }

        

        int curr = grid[i][j];
        int cost = curr == 0 ? 0 : 1;
        
        if(cost > k){
            return dp[i][j][k] = -1;
        }

        if(i == n-1 && j == m-1){
            return dp[i][j][k] = curr;
        }

        

    

        int right = helper(i,j+1,grid,k-cost,n,m,dp); 
        int down = helper(i+1,j,grid,k-cost,n,m,dp); 

        if(right == - 1 && down == -1){
            return dp[i][j][k] = -1;
        }
        
        return dp[i][j][k] = curr + Math.max(down,right);

        
    }
    public int maxPathScore(int[][] grid, int k) {

        int i = 0;
        int j = 0;

        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][k+1];

        for(int[][]arr : dp){
            for(int[]brr : arr){
                Arrays.fill(brr,Integer.MIN_VALUE);
            }
        }

        return helper(i,j,grid,k,n,m,dp);
        
    }
}