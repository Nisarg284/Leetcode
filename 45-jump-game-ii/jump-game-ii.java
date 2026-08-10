class Solution {

    public static int helper(int idx,int val,int n,int[]nums,int[]dp){
        if(idx >= n-1){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        int steps = Integer.MAX_VALUE / 2;
        for(int i = idx+1;i<= idx + val && i < n ; i++){

            int step = 1 + helper(i,nums[i],n,nums,dp);

            steps = Math.min(step,steps);
        }

        return dp[idx] = steps;
    }
    public int jump(int[] nums) {

        int idx = 0;
        int val = nums[0];
        int n = nums.length;

        if(n == 0 || n == 1){
            return 0;
        }
        int[]dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(idx,val,n,nums,dp);
    }
}