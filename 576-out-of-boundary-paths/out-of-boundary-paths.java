class Solution {

    public static int helper(int m, int n, int maxMove, int startRow, int startCol,int[][][]dp){
        if(startRow >= m || startCol >= n || startRow < 0 || startCol < 0){
            return 1;
        }

        // if(dp[startRow][startCol][maxMove] != 0){

        //     return dp[startRow][startCol][maxMove];
        // }

        if(maxMove == 0){
            return 0;
        }

        if(dp[startRow][startCol][maxMove] != -1){

            return dp[startRow][startCol][maxMove];
        }

        int mod = 1000000007;

        // int up = helper(m,n,maxMove - 1,startRow -1,startCol,dp);
        // int right = helper(m,n,maxMove - 1,startRow,startCol+1,dp);
        // int down = helper(m,n,maxMove - 1,startRow+1,startCol,dp);
        // int left = helper(m,n,maxMove - 1,startRow,startCol-1,dp);

        // // return dp[startRow][startCol][maxMove] = (int)((up + right + down + left) % mod);
        // return dp[startRow][startCol][maxMove] = (int)((up + right + down + left) % mod);


                long ans = 0;

                ans = (ans + helper(m, n, maxMove - 1, startRow - 1, startCol, dp)) % mod;
                ans = (ans + helper(m, n, maxMove - 1, startRow, startCol + 1, dp)) % mod;
                ans = (ans + helper(m, n, maxMove - 1, startRow + 1, startCol, dp)) % mod;
                ans = (ans + helper(m, n, maxMove - 1, startRow, startCol - 1, dp)) % mod;

                return dp[startRow][startCol][maxMove] = (int) ans;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startCol) {


        int[][][]dp = new int[m][n][maxMove+1];

        for(int[][]arr: dp){
            for(int[]brr : arr){
                Arrays.fill(brr,-1);
            }
        }

        return helper(m,n,maxMove,startRow,startCol,dp);
        
        
    }
}