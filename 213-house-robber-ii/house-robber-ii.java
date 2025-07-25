class Solution {

    public static int helper(int[]dp,int[]nums,int n,int stop)
    {
        if(n < stop)
        {
            return 0;
        }

        

        // if(flag == true)
        // {
        //     return nums[n];
        // }


        if(dp[n] != -1)
        {
            return dp[n];
        }

        int steal = nums[n] + helper(dp,nums,n-2,stop);
        int skip = helper(dp,nums,n-1,stop);

        // if(flag && n == nums.length - 1) {
        //     dp[n] = skip;
        // } else {
        //     dp[n] = Math.max(steal, skip);
        // }

        return dp[n] = Math.max(steal,skip);
    }
    public int rob(int[] nums) {


        int n = nums.length;

        if(n == 1)
        {
            return nums[0];
        }
        int[] dp = new int[n];

        Arrays.fill(dp,-1);

        int ans1 = helper(dp,nums,n-1,1);
        Arrays.fill(dp,-1);

        int ans2 = helper(dp,nums,n-2,0);

        return Math.max(ans1,ans2);
        
    }
}