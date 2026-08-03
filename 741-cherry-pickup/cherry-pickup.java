class Solution {



    public static int helper(int r1,int c1,int r2,int c2,int n, int[][]grid,Integer[][][][] dp){

        if(r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1){
            return Integer.MIN_VALUE;
        }

        if(dp[r1][c1][r2][c2] != null){
            return dp[r1][c1][r2][c2];
        }

        if(r1 == n-1 && c1 == n-1){
            return grid[r1][c1];
        }

        if(r2 == n-1 && c2 == n-1){
            return grid[r2][c2];
        }

        int charries = 0;
        if(r1 == r2 && c1 == c2){
            charries += grid[r1][c1];
        }else{
            charries += (grid[r1][c1] + grid[r2][c2]);
        }

        // System.out.println("P1 ---------------> r1: "+r1 + " , c1: "+c1);
        // System.out.println("P2 ---------------> r2: "+r2 + " , c2: "+c2);
        // System.out.println();
        int rrAndrd = Math.max(helper(r1,c1+1,r2,c2+1,n,grid,dp),helper(r1,c1+1,r2+1,c2,n,grid,dp));
        int drAnddd = Math.max(helper(r1+1,c1,r2,c2+1,n,grid,dp),helper(r1+1,c1,r2+1,c2,n,grid,dp));

        int maxCharries = Math.max(rrAndrd,drAnddd);

        return dp[r1][c1][r2][c2] = maxCharries == Integer.MIN_VALUE ? Integer.MIN_VALUE : maxCharries + charries;
    }

    public int cherryPickup(int[][] grid) {

        int r1 = 0;
        int r2 = 0;
        int c1 = 0;
        int c2 = 0;
        int n = grid.length;

        Integer[][][][] dp = new Integer[n][n][n][n];

        int ans = helper(r1,c1,r2,c2,n,grid,dp);


        return ans == Integer.MIN_VALUE ? 0 : ans;
        
    }
}