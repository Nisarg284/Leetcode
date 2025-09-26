class Solution {

    public static int helper(int row,int col,List<List<Integer>> triangle,int[][]dp,int n)
    {
        if(row == n-1)
        {
            return triangle.get(row).get(col);
        }

        if(dp[row][col] != Integer.MAX_VALUE)
        {
            return dp[row][col];
        }

        return dp[row][col] = triangle.get(row).get(col) + Math.min(helper(row+1,col,triangle,dp,n),helper(row+1,col+1,triangle,dp,n));
    }
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        int row = 0;
        int col = 0;

        int[][]dp = new int[n][n];

        for(int[]d : dp)
        {
            Arrays.fill(d,Integer.MAX_VALUE);
        }
        return helper(row,col,triangle,dp,n);
        
    }
}