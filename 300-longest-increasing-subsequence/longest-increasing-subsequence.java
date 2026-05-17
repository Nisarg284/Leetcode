class Solution {


    public static int helper(int currIdx,int prevIdx,int[]arr,int n,int[][]dp){

        if(currIdx >= n){
            return 0;
        }

        if(prevIdx != -1 && dp[currIdx][prevIdx+1] != Integer.MIN_VALUE){
            return dp[currIdx][prevIdx + 1];

        }

        int take = 0;
        int skip = 0;

        if(prevIdx == -1 || arr[currIdx] > arr[prevIdx]){
            take = 1 + helper(currIdx + 1,currIdx,arr,n,dp);
        }

        skip = helper(currIdx + 1,prevIdx,arr,n,dp);

        return dp[currIdx][prevIdx+1] = Math.max(take,skip);
    }
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int currIdx = 0;
        int prevIdx = -1;

        int[][] dp = new int[n][n+1];

        for(int[] arr : dp){
            Arrays.fill(arr,Integer.MIN_VALUE);
        }

        return helper(currIdx,prevIdx,nums,n,dp);
        
    }
}