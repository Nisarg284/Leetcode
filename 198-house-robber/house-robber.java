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

        return helper(nums,dp,n-1);
        
    }
}