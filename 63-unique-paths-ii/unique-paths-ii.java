class Solution {

    public static int helper(int[][]arr,int row,int col,int[][]memo)
    {
        if(row < 0 || col < 0 || arr[row][col] == 1)
        {
            return 0;
        }

        if(row == 0 && col == 0)
        {
            return 1;
        }

        if(memo[row][col] != 0)
        {
            return memo[row][col];
        }


        int left = helper(arr,row,col-1,memo);
        int up = helper(arr,row-1,col,memo);

        memo[row][col] = left + up;

        return memo[row][col];

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {


        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        
        int[][] memo = new int[m][n];

        int row = m-1;
        int col = n-1;

        return helper(obstacleGrid,row,col,memo);
        
    }
}