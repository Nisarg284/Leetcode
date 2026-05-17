class Solution {


    public static boolean helper(int idx,int targetSum,int[]arr,Boolean[][]dp){
        if(idx < 0){
            return false;
        }

        if(targetSum == 0){
            return true;
        }

        if(dp[idx][targetSum] != null){
            return dp[idx][targetSum];
        }

        boolean take = false;
        boolean skip = false;

        if(targetSum >= arr[idx]){
            take = helper(idx-1,targetSum - arr[idx],arr,dp);
        }

        skip = helper(idx-1,targetSum,arr,dp);

        return dp[idx][targetSum] = take || skip;
    }
    public boolean canPartition(int[] nums) {

        int n = nums.length;
        int sum = 0;

        for(int i : nums){
            sum += i;
        }

        if(sum % 2 != 0){
            return false;
        }

        int targetSum = sum / 2;

        Boolean[][]dp = new Boolean[n][targetSum+1];

        int idx = n-1;

        return helper(idx,targetSum,nums,dp); 


        
    }
}