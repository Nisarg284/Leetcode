class Solution {
    public static int helper(int i,int j,int start,int end,int[]arr,Integer[][]dp){

        if(i > j){
            return 0;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        int mini = (int)1e9;

        for(int k = i;k<=j;k++){
            int currCost = end - start;

            int left = helper(i , k-1,start,arr[k],arr,dp);
            int right = helper(k + 1 , j,arr[k],end,arr,dp);

            int totalCost = currCost + left + right;
            mini = Math.min(mini,totalCost);
        }

        return dp[i][j] = mini;
    }
    public int minCost(int n, int[] cuts) {

        int len = cuts.length;

        int i = 0;
        int j = len - 1;

        Arrays.sort(cuts);

        int start = 0;
        int end = n;

        Integer[][]dp = new Integer[len][len];

        return helper(i,j,start,end,cuts,dp);

        
        
    }
}