class Solution {

    public static int helper(int idx,int prevIdx,int n,int[]arr,int[][]dp){

        if(idx >= n){
            return 0;
        }

        if(prevIdx != -1 && dp[idx][prevIdx+1] != -1){
            return dp[idx][prevIdx+1];
        }

        int take = 0;
        int skip = helper(idx + 1,prevIdx,n,arr,dp);

        if(prevIdx == -1 || arr[idx] > arr[prevIdx]){
            take = 1 + helper(idx+1,idx,n,arr,dp);
        }

        return dp[idx][prevIdx+1] = Math.max(take,skip);
    }
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int idx = 0;
        int prevIdx = -1;

        int[][]dp = new int[n][n+1];
        for(int[]arr : dp){
            Arrays.fill(arr,-1);
        }

        return helper(idx,prevIdx,n,nums,dp);
        
    }
}