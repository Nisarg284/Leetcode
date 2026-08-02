class Solution {

    public static int helper(int row,int col,int n,int m,int[][]arr,int[][]dp){

        if(row >= n || col >= m || row < 0 || col < 0 || arr[row][col] == 1){
            return 0;
        }

        if(row == n-1 && col == m-1){
            return 1;
        }

        if(dp[row][col] != 0){
            return dp[row][col];
        }


        // up
        // helper(row - 1,col,n,m,arr,vis,count);

        // right
        int right = helper(row,col+1,n,m,arr,dp);

        // down
        int down = helper(row + 1,col,n,m,arr,dp);

        //left
        // helper(row,col-1,n,m,arr,vis,count);

        return dp[row][col] = right + down;

    }
    public int uniquePathsWithObstacles(int[][] arr) {

        int row = 0;
        int col = 0;
        int n = arr.length;
        int m = arr[0].length;


        int[][] dp = new int[n][m];

        int[]count = new int[1];

        return helper(row,col,n,m,arr,dp);        
    }
}