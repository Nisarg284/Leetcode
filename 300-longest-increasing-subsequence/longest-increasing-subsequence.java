class Solution {

    public static int helper(int currIdx,int prevIdx,int[]arr,int[][]dp){
        if(currIdx >= arr.length){
            return 0;
        }

        if( dp[currIdx][prevIdx+1] != -1){
            return dp[currIdx][prevIdx+1];
        }

        int skip = helper(currIdx+1,prevIdx,arr,dp);
        int take = 0;
        if(prevIdx == -1 || arr[prevIdx] < arr[currIdx]){
            take = 1 + helper(currIdx + 1,currIdx,arr,dp);
        }

        return dp[currIdx][prevIdx+1] = Math.max(take,skip);
    }
    public int lengthOfLIS(int[] nums) {

        int currIdx = 0;
        int prevTakenIdx = -1;

        int n = nums.length;
        int[][]dp = new int[n][n+1];

        for(int[]arr : dp){
            Arrays.fill(arr,-1);
        }

        return helper(currIdx,prevTakenIdx,nums,dp);
        
    }
}