class Solution {

    public int helper(int currIdx,int prevIdx,int[]nums,int n,int[][]dp)
    {
        if(currIdx >= n)
        {
            return 0;
        }

        if(prevIdx != -1 && dp[currIdx][prevIdx+1] != Integer.MIN_VALUE)
        {
            return dp[currIdx][prevIdx+1];
        }

        // int counter = 0;
        int skip = helper(currIdx+1,prevIdx,nums,n,dp);
        int take = 0;
        if(prevIdx == -1 || nums[prevIdx] < nums[currIdx])
        {
            take = 1 + helper(currIdx + 1,currIdx,nums,n,dp);
        }

        return dp[currIdx][prevIdx+1] = Math.max(take,skip);

    }

    public int lengthOfLIS(int[] nums) {


        int n = nums.length;



        int[][]dp = new int[n][n+1];


        for(int[]arr : dp)
        {
            Arrays.fill(arr,Integer.MIN_VALUE);
        }
        int currIdx = 0;
        int prevIdx = -1;

        return helper(currIdx,prevIdx,nums,n,dp);
        
    }
}