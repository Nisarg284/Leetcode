class Solution {

    public static int helper(int row,int col,int[][]dp,int[][]matrix,int n)
    {
        if(col < 0 || col >=n)
        {
            return Integer.MAX_VALUE;
        }

        if(row == 0)
        {
            return matrix[row][col];
        }

        if(dp[row][col] != Integer.MAX_VALUE)
        {
            return dp[row][col];
        }

        int top = helper(row-1,col,dp,matrix,n);
        int leftTopDiagonal = helper(row-1,col-1,dp,matrix,n);
        int rightTopDiagonal = helper(row-1,col+1,dp,matrix,n);

        return dp[row][col] = matrix[row][col] + Math.min(top,Math.min(leftTopDiagonal,rightTopDiagonal));
    }
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        int[][] dp = new int[n][n];
        for(int arr[] : dp)
        {
            Arrays.fill(arr,Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++)
        {
            ans = Math.min(ans,helper(n-1,i,dp,matrix,n));
        }

        return ans;
        
    }
}