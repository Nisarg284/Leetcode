class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int i = 0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        

        if(sum % 2!=0)
        {
            return false;
        }

        int targetSum = sum / 2;
        int n = nums.length;

        boolean[][] dp = new boolean[n+1][targetSum+1];

        for(int i=0;i<n;i++)
        {
            dp[i][0] = true;
        }

        for(int i=1;i<=n;i++)
        {
            for(int j = 1;j<=targetSum;j++)
            {
                if(nums[i-1] <= j)
                {
                    boolean accept = dp[i-1][j-nums[i-1]];
                    boolean reject = dp[i-1][j];

                    dp[i][j] = accept || reject;
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][targetSum];

    }
}