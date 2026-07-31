class Solution {

    public static int helper(int house,int n,int[] arr,int[]dp){

        if(house < 0){
            return 0;
        }

        if(dp[house] != -1){
            return dp[house];
        }

        int stealAmount = 0;

        int steal = arr[house] + helper(house - 2,n,arr,dp); 
        int skip =  helper(house - 1,n,arr,dp); 

        stealAmount = Math.max(steal,skip);
        return dp[house] = stealAmount;
    }
    public int rob(int[] nums) {


        int n = nums.length;
        int house = n-1;
        int[]dp = new int[n];

        Arrays.fill(dp,-1);

        return helper(house,n,nums,dp);
        
    }
}