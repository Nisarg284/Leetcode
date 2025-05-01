class Solution {
    public int findTargetSumWays(int[] nums, int target) {
    //     int n = arr.length;
    //    int sum = 0;
    //    for(int i:arr)
    //    {
    //     sum+=i;
    //    }

    //    if((sum-diff)%2 == 1 || sum < diff)
    //    {
    //     return 0;
    //    }

    //    int s1 = (diff + sum) / 2;

    //    int[][] dp = new int[n+1][s1+1];

    //    for(int i=0;i<=n;i++)
    //    {
    //     dp[i][0] = 1;
    //    }

    //    for(int i = 1;i<=n;i++)
    //    {
    //     for(int j = 0;j<=s1;j++)
    //     {
    //         if(arr[i-1] <= j)
    //         {
    //             int accept = dp[i-1][j-arr[i-1]];
    //             int reject = dp[i-1][j];

    //             dp[i][j] = accept + reject;
    //         }else{
    //             dp[i][j] = dp[i-1][j];
    //         }
    //     }
    //    }

    //    return dp[n][s1];


    // /Solution 1
        int sum = 0;
        for(int x : nums)
            sum += x;
        if(((sum - target) % 2 == 1) || (target > sum))
            return 0;
        
        int n = nums.length;
        int s2 = (sum - target)/2;
        int[][] t = new int[n + 1][s2 + 1];
        t[0][0] = 1;
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < s2 + 1; j++) {
                if(nums[i - 1] <= j)
                    t[i][j] = t[i-1][j] + t[i - 1][j - nums[i - 1]];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][s2];
    }
}