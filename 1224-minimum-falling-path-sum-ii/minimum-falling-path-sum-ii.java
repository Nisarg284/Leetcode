class Solution {

    public static int helper(int row,int col,int n,int[][]grid,int[][]dp){
        // if(col >= n || col < 0){
        //     return 0;
        // }

        // System.out.print(grid[row][col] +" ");

        if(dp[row][col] != Integer.MIN_VALUE){
            return dp[row][col];
        }


        if(row == n-1){
            return grid[row][col];
        }

        // if(dp[row][col] != Integer.MIN_VALUE){
        //     return dp[row][col];
        // }


        // int leftBottom = 0;
        // int rightBottom = 0;

        // for(int currCol = col + 1;currCol < n;currCol++){
        //     leftBottom =  helper(row + 1,currCol,n,grid);
        // }

        // for(int currCol = col - 1;currCol >=0;currCol--){
        //     rightBottom =  grid[row][col] + helper(row + 1,currCol,n,grid);
        // }

        // System.out.println();

        int currMinCost = Integer.MAX_VALUE;

        for(int i = 0;i<n;i++){
            if(i == col){
                continue;
            }

            int currColEle = helper(row+1,i,n,grid,dp);
            currMinCost = Math.min(currMinCost,currColEle);

        }

        return dp[row][col] = currMinCost + grid[row][col];
    }
    public int minFallingPathSum(int[][] grid) {

        int n = grid.length;

        int[][]dp = new int[n][n];

        for(int[]arr: dp){
            Arrays.fill(arr,Integer.MIN_VALUE);
        }

        int row = 0;
        // int col = 0;

        int minSum = Integer.MAX_VALUE;

        for(int col = 0;col<n;col++){

            
            int colCost = helper(row,col,n,grid,dp);

            minSum = Math.min(minSum,colCost);
        }

        return minSum;



        
    }
}