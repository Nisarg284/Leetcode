class Solution {

    public static int helper(int[]nums,int n,int target,int dp[][])
    {
        if(target == 0)
        {
            return 0;
        }

        if(n == 0)
        {
            return 1;
        }

        if(dp[n][target] != -1)
        {
            return dp[n][target];
        }

        if(nums[n-1] <= target)
        {
            int accept = helper(nums,n-1,target - nums[n-1],dp);
            int reject = helper(nums,n-1,target,dp);

            if( accept == 0 || reject == 0)
            {
                dp[n][target] = 0;
            }else{
                dp[n][target] = 1;
            }
        }else{
            dp[n][target] = helper(nums,n-1,target,dp);
        }

        return dp[n][target];
    }
    public boolean canPartition(int[] nums) {

        int n = nums.length;
        int sum = 0;
        for(int i =0;i<n;i++)
        {
            sum+=nums[i];
        }

        if(sum % 2 != 0)
        {
            return false;
        }

        int target = sum/2;

        int dp[][] = new int[n+1][target+1];

        for(int i = 0;i<=n;i++)
        {
            for(int j = 0;j<=target;j++)
            {
                dp[i][j] = -1;
            }
        }

        int ans = helper(nums,n,target,dp);

        if(ans == 0)
        {
            return true;
        }

        return false;        
    }
}