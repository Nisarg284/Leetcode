class Solution {

    public static boolean helper(int idx,int[]arr,int n,Boolean[]dp){
        if(idx >= n-1){
            return true;
        }

        if(dp[idx] != null){
            return dp[idx];
        }

        boolean flag = false;

        for(int i = idx+1;i<n && i <= idx + arr[idx];i++){
            if(helper(i,arr,n,dp)){
                return dp[idx] = true;
            }
        }

        return dp[idx] = flag;
    }
    public boolean canJump(int[] nums) {

        int idx = 0;
        int cap = 0;

        Boolean[]dp = new Boolean[nums.length];

        return helper(idx,nums,nums.length,dp);

        
    }
}