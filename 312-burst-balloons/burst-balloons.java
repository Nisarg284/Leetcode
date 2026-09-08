class Solution {

    public static int helper(int i,int j,int[]arr,Integer[][]dp){
        if( i > j){
            return 0;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        int maxi = (int)-1e9;

        for(int k = i;k<=j;k++){

            int cost = arr[i-1] * arr[k] * arr[j+1];

            int left = helper(i,k-1,arr,dp);
            int right = helper(k+1,j,arr,dp);

            int totalCost = cost + left + right;

            maxi = Math.max(totalCost,maxi);
        }

        return dp[i][j] = maxi;
    }
    public int maxCoins(int[] nums) {

        int n = nums.length;
        int[]arr = new int[n+2];

        arr[0] = 1;
        arr[n+1] = 1;
        for(int i = 0;i<n;i++){
            arr[i+1] = nums[i];
        }

        // for(int ele : arr){
        //     System.out.print(ele +" ");
        // }

        Integer[][]dp = new Integer[n+1][n+1];

        int i = 1;
        int j = n;


        return helper(i,j,arr,dp);


        
    }
}