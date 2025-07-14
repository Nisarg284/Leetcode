class Solution {

    public static int helper(int[]arr,int days,int idx,int n,int[][] dp)
    {
        if(days == 1)
        {
            int max = Integer.MIN_VALUE;
            for(int i = idx;i<n;i++)
            {
                max = Math.max(max,arr[i]);
            }
            return max;
        }

        if(dp[idx][days] != -1)
        {
            return dp[idx][days];
        }

        int min = Integer.MAX_VALUE;
        int currMax = Integer.MIN_VALUE;
        for(int i = idx;i<=n-days;i++)
        {
            currMax = Math.max(currMax,arr[i]);
            dp[idx][days] = min =  Math.min(min,currMax + helper(arr, days-1, i+1, n,dp));
        }



        return dp[idx][days];


    }
    public int minDifficulty(int[] arr, int days) {

        int n = arr.length;
        if(n < days)
        {
            return -1;
        }
        int[][] dp = new int[n+1][days+1];
        for(int[]i : dp)
        {
            Arrays.fill(i,-1);
        }

        int idx = 0;

        return helper(arr,days,0,n,dp);
        
    }
}