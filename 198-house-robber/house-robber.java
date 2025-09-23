class Solution {

    public static int helper(int idx,int[]dp,int[] nums)
    {
        if(idx < 0)
        {
            return 0;
        }

        if(dp[idx] != -1)
        {
            return dp[idx];
        }

        int steal = nums[idx] + helper(idx-2,dp,nums);
        int skip = helper(idx-1,dp,nums);

        return dp[idx] = Math.max(steal,skip);
    }
    public int rob(int[] nums) {



        int n = nums.length;

        if(n == 1)
        {
            return nums[0];
        }
        int[]dp = new int[n];

        Arrays.fill(dp,-1);

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        return helper(n-1,dp,nums);

        
    }
}