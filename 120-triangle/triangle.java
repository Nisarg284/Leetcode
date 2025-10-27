class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        int[][] dp = new int[n][n];

        for(int[]arr : dp)
        {
            Arrays.fill(arr,Integer.MAX_VALUE);
        }

        dp[0][0] = triangle.get(0).get(0);
        for(int  i = 1;i<n;i++)
        {
            dp[i][0] = triangle.get(i).get(0) + dp[i-1][0];
        }


        // for(int[]arr : dp)
        // {
        //     for(int i : arr)
        //     {
        //         System.out.print(i+" ");
        //     }
        //     System.out.println();
        // }

        // System.out.println("-------------------------");

        for(int i = 1;i<n;i++)
        {
            List<Integer> currList = triangle.get(i);
            for(int j = 1;j<currList.size();j++)
            {
                int top = dp[i-1][j];
                int leftTopDiagonal = dp[i-1][j-1];

                dp[i][j] = currList.get(j) + Math.min(top,leftTopDiagonal);
            }
        }


        // for(int[]arr : dp)
        // {
        //     for(int i : arr)
        //     {
        //         System.out.print(i+" ");
        //     }
        //     System.out.println();
        // }

        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++)
        {
            // System.out.println("ans ---> "+ dp[n-1][i]);
            ans = Math.min(ans,dp[n-1][i]);
        }

        return ans;
        
    }
}