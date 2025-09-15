class Solution {

    public static int helper(int idx,int[]nums,int[]dp)
    {
        if(idx < 0)
        {
            return 0;
        }

        if(dp[idx] != -1)
        {
            return dp[idx];
        }

        int steal = nums[idx] + helper(idx-2,nums,dp);
        int skip = helper(idx-1,nums,dp);

        dp[idx] = Math.max(steal,skip);
        return dp[idx];
    }
    public int rob(int[] nums) {


        int n = nums.length;
        if(n == 1)
        {
            return nums[0];
        }

        int[] dp = new int[n];

        Arrays.fill(dp,-1);

        int idx = n-1;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);

        return helper(idx,nums,dp);
        
        
    }
}