class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        int[][]dp = new int[n][n];

        for(int[]arr : dp)
        {
            Arrays.fill(arr,Integer.MAX_VALUE);
        }

        dp[0][0] = matrix[0][0];

        

        // filling first col
        // for(int i = 1;i<n;i++)
        // {
        //     dp[i][0] = matrix[i][0] + dp[i-1][0];
        // }

        // filling first row
        // int minVal = Arrays.stream(matrix[0]).min().getAsInt();

        // Arrays.fill(matrix[0],minVal);
        for(int i = 0;i<n;i++)
        {
            dp[0][i] = matrix[0][i];
        }

        // System.out.println(minVal);

        // for(int[]arr : dp)
        // {
        //     for(int i : arr)
        //     {
        //         System.out.print(i+" ");
        //     }
        //     System.out.println();
        // }

        for(int i = 1;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                int top = dp[i-1][j];
                int leftTopDiagonal = Integer.MAX_VALUE;
                int rightTopDiagonal = Integer.MAX_VALUE;

                if(j > 0)
                {
                    leftTopDiagonal = dp[i-1][j-1];
                }

                if(j < n-1)
                {
                    rightTopDiagonal = dp[i-1][j+1];
                }

                dp[i][j] = matrix[i][j] + Math.min(top,Math.min(leftTopDiagonal,rightTopDiagonal));
            }
        }


        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++)
        {
            ans = Math.min(ans,dp[n-1][i]);
        }



        return ans;
        
    }
}