class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[]dp = new int[n];

        Arrays.fill(dp,1);

        for(int i = 0;i<n;i++)
        {
            int maxDp = 1;
            for(int j = 0;j<i;j++)
            {
                if(nums[i] > nums[j])
                {
                   maxDp = Math.max(maxDp,dp[i] + dp[j]);
                }
            }

            dp[i] = maxDp;
        }


        int maxLen = 0;
        for(int i = 0;i<n;i++)
        {
            maxLen = Math.max(maxLen,dp[i]);
        }

        return maxLen;
        
    }
}