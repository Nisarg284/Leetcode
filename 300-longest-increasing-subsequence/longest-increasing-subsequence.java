class Solution {

    public static int helper(int curr,int prev,int[]arr,int[][]dp){
        if(curr >= arr.length){
            return 0;
        }

        if( dp[curr][prev+1] != -1){
            return dp[curr][prev+1];
        }

        int take = 0;
        int skip = helper(curr + 1,prev,arr,dp);

        if(prev == -1 || arr[curr] > arr[prev]){
            take = 1 + helper(curr + 1, curr,arr,dp);
        }

        return dp[curr][prev+1] = Math.max(take,skip);
    }
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int i = 0;
        int j = -1;

        int[][]dp = new int[n][n+1];

        for(int[]arr: dp){
            Arrays.fill(arr,-1);
        }

        return helper(i,j,nums,dp);
        
    }
}