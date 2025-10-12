class Solution {

    public static int helper(int idx,int target,int arr[],int[][]dp)
    {
        if(idx == 0)
        {
            if(arr[idx] == 0 && target == 0)
            {
                return 2;
            }
            if( target == 0 || target == arr[idx])
            {
                return 1;
            }
            return 0;
        }

        // if(idx < 0)
        // {
        //     if(target == 0)
        //     {
        //         return 1;
        //     }

        //     return 0;
        // }

        if(dp[idx][target] != -1)
        {
            return dp[idx][target];
        }

        // int plus = helper(idx-1,target - arr[idx],arr,dp,offSet);
        // int minus = helper(idx-1,target + arr[idx],arr,dp,offSet);

        int take = 0;
        int skip = helper(idx-1,target,arr,dp);

        if(arr[idx] <= target)
        {
            take = helper(idx-1,target - arr[idx],arr,dp);
        }

        return dp[idx][target] = take + skip;

        // return dp[idx][target + offSet] =  plus + minus;
    }
    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;

        int sum = 0;

        for(int i = 0;i<n;i++)
        {
            sum+=nums[i];
        }

        if(sum - target < 0)
        {
            return 0;
        }

        if((sum - target) % 2 == 1)
        {
            return 0;
        }

        sum = (sum - target)/2;

        int dp[][] = new int[n][sum+1];

        for(int arr[] : dp)
        {
            Arrays.fill(arr,-1);
        }

        int ans = helper(n-1,sum,nums,dp);

        return ans;
        
    }
}