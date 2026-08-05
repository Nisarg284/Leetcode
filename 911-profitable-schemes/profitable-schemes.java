class Solution {

    public static int helper(int idx,int sum,int n,int minProfit,int[]group,int[]profit,int[][][]dp){

        if(idx >= group.length){
            return sum >= minProfit ? 1 : 0;
        }

        if(dp[idx][n][sum] != -1){
            return dp[idx][n][sum];
        }

        int ways = 0;
        int mod = 1000000007;
       
        
        int skip = helper(idx+1,sum,n,minProfit,group,profit,dp) % mod;
        int take = 0;
        if(group[idx] <= n){
            int newSum = Math.min(sum + profit[idx], minProfit);
            take = helper(idx+1,newSum,n - group[idx],minProfit,group,profit,dp) % mod;
        }

        ways += (take + skip) % mod;

        return dp[idx][n][sum] = ways;
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {

        int len = group.length;
        int idx = 0;
        int sum = 0;

        int dp[][][] = new int[len][n+1][minProfit+1];

        for(int[][]arr : dp){
            for(int[]brr : arr){
                Arrays.fill(brr,-1);
            }
        }


        return helper(idx,sum,n,minProfit,group,profit,dp);
    }
}