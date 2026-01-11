class Solution {


    public int helper(int idx,int stopIdx,int[]nums,int[]dp)
    {
        if(idx < stopIdx)
        {
            return 0;
        }


        if(dp[idx] != -1)
        {
            return dp[idx];
        }


        int take = nums[idx] + helper(idx-2,stopIdx,nums,dp);
        int skip = helper(idx-1,stopIdx,nums,dp);


        return dp[idx] = Math.max(take,skip);
    }
    public int rob(int[] nums) {

        int n = nums.length;

        if(n==1){
            return nums[0];
        }


        int[] dp = new int[n];

        Arrays.fill(dp,-1);
        int last = helper(n-1,1,nums,dp);

        Arrays.fill(dp,-1);
        int secLast = helper(n-2,0,nums,dp);


        return Math.max(last,secLast);
        
    }
}