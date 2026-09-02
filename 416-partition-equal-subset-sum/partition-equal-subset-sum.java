class Solution {

    public static boolean helper(int idx,int sum,int[]arr,Boolean[][]dp){

        if(idx >= arr.length){
            return false;
        }
        
        if(sum == 0){
            return true;
        }


        if(dp[idx][sum] != null){
            return dp[idx][sum];
        }

        

        boolean skip = helper(idx + 1,sum,arr,dp);
        boolean take = false;

        if(sum >= arr[idx]){
            take = helper(idx + 1,sum - arr[idx],arr,dp);
        }


        return dp[idx][sum] = take || skip;
    }
    public boolean canPartition(int[] nums) {

        int totalSum = 0;
        int n = nums.length;

        for(int i : nums){
            totalSum += i;
        }

        if(totalSum % 2 != 0){
            return false;
        }

        Boolean[][]dp = new Boolean[n][(totalSum / 2) + 1];

        return helper(0,totalSum / 2,nums,dp);
        
    }
}
