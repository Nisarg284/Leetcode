class Solution {

    public static int helper(int[] nums,int[]dp,int n)
    {
        if(n < 0)
        {
            return 0;
        }

        if(dp[n] != -1)
        {
            return dp[n];
        }

        int steal = nums[n] + helper(nums,dp,n-2);
        int skip = helper(nums,dp,n-1);

        dp[n] = Math.max(steal,skip);

        return dp[n];
    }
    public int rob(int[] nums) {

        int n = nums.length;

        int[]dp = new int[n];
        Arrays.fill(dp,-1);

        // return helper(nums,dp,n-1);

        if( n == 1 )
        {
            return nums[0];
        }


        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i = 2;i<n;i++)
        {
            dp[i] = Math.max(nums[i] + dp[i-2],dp[i-1]);
        }

        return dp[n-1];
        
    }
}