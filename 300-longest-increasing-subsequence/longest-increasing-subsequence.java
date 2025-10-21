class Solution {

    public static int helper(int currIdx,int prevIdx,int n,int[]arr,int[][]dp)
    {
        if(currIdx >= n)
        {
            return 0;
        }

        if( prevIdx != -1 && dp[currIdx][prevIdx+1] != Integer.MIN_VALUE)
        {
            return dp[currIdx][prevIdx+1];
        }

        int skip = helper(currIdx+1,prevIdx,n,arr,dp);
        int accept = Integer.MIN_VALUE;

        // System.out.println("currEle ---> "+ arr[currIdx] + " prev Ele ---> "+ arr[prevIdx]);

        if( prevIdx == -1 || arr[prevIdx] < arr[currIdx])
        {
            accept = 1 + helper(currIdx+1,currIdx,n,arr,dp);
        }

        return dp[currIdx][prevIdx+1] = Math.max(skip,accept);
    }
    public int lengthOfLIS(int[] nums) {
        

        int n = nums.length;
        int idx = 0;

        int prev = -1;

        int[][]dp = new int[n][n+1];

        for(int[]arr : dp)
        {
            Arrays.fill(arr,Integer.MIN_VALUE);
        }

        return helper(0,-1,n,nums,dp);
    }
}