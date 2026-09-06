class Solution {

    public static int helper(int idx,int[]nums,int n,Integer[]dp){
        if(idx >= n){
            return 0;
        }

        if(dp[idx] != null){
            return dp[idx];
        }

        int rob = nums[idx] + helper(idx + 2,nums,n,dp);
        int skip = helper(idx + 1,nums,n,dp);

        return dp[idx] = Math.max(rob,skip);
    }
    public int rob(int[] nums) {

        int n = nums.length;

        if(n == 1){
            return nums[0];
        }

        Integer[]dp = new Integer[n];

        int firstAns = helper(0,nums,n-1,dp);

        Arrays.fill(dp,null);
        int secondAns = helper(1,nums,n,dp);

        return Math.max(firstAns,secondAns);
        
    }
}