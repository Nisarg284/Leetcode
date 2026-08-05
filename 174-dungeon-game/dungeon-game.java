class Solution {


    public static int helper(int i,int j,int n,int m,int[][]arr,int[][]dp){
        if(i >= n || j >= m){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i == n-1 && j == m-1){
            return Math.max(1,1 - arr[i][j]);
        }

        int down = helper(i+1,j,n,m,arr,dp);
        int right = helper(i,j+1,n,m,arr,dp);

        int minHealth = Math.min(down,right) - arr[i][j];

        return dp[i][j] = Math.max(1,minHealth);
    }

    public int calculateMinimumHP(int[][] dungeon) {

        int i = 0;
        int j = 0;
        int n = dungeon.length;
        int m = dungeon[0].length;

        int[][] dp = new int[n][m];

        for(int[]arr: dp){
            Arrays.fill(arr,-1);
        }

        return helper(i,j,n,m,dungeon,dp);
        
    }
}