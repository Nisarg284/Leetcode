class Solution {

    public static int helper(int idx,int[]arr,int[]dp){
        if(idx >= arr.length){
            return 0;
        }

        if(dp[idx] != Integer.MIN_VALUE){
            return dp[idx];
        }

        int steal = arr[idx] + helper(idx + 2,arr,dp);
        int skip = helper(idx + 1,arr,dp);

        return dp[idx] = Math.max(steal,skip);
    }
    public int rob(int[] nums) {

        int n = nums.length;

        int[]dp = new int[n+1];

        Arrays.fill(dp,Integer.MIN_VALUE);

        return helper(0,nums,dp);
        
    }
}