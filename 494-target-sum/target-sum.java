class Solution {
    public int findTargetSumWays(int[] arr, int diff) {
        int n = arr.length;
       int sum = 0;
       for(int i:arr)
       {
        sum+=i;
       }

       if((sum-diff)%2 == 1 || sum < diff)
       {
        return 0;
       }

       int s1 = (sum - diff) / 2;

       int[][] dp = new int[n+1][s1+1];

    //    dp[0][0] = 1;

       for(int i=0;i<=n;i++)
       {
        dp[i][0] = 1;
       }

       for(int i = 1;i<=n;i++)
       {
        for(int j = 0;j<=s1;j++)
        {
            if(arr[i-1] <= j)
            {
                int accept = dp[i-1][j-arr[i-1]];
                int reject = dp[i-1][j];

                dp[i][j] = accept + reject;
            }else{
                dp[i][j] = dp[i-1][j];
            }
        }
       }

       return dp[n][s1];
    }
}