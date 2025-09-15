class Solution {

    public static int helper(int idx,int[]nums,int[]dp,int stop)
    {
        if(idx < stop)
        {
            return 0;
        }

        if(idx == stop)
        {
            return nums[idx];
        }

        if(dp[idx] != -1)
        {
            return dp[idx];
        }

        int steal = nums[idx] + helper(idx-2,nums,dp,stop);
        int skip = helper(idx-1,nums,dp,stop);

        return dp[idx] = Math.max(steal,skip);
    }
    public int rob(int[] nums) {

        int n = nums.length;

        if(n == 1)
        {
            return nums[0];
        }
        int[]dp = new int[n];

        // int start = n-1;
        int idx = n-1;
        Arrays.fill(dp,-1);
        int stealFromFirst = helper(idx,nums,dp,1);

        Arrays.fill(dp,-1);
        int stealFromSecond = helper(idx-1,nums,dp,0);

        return Math.max(stealFromFirst,stealFromSecond);
    }
}