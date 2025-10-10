class Solution {

    public static boolean canPartitionTab(int[]arr,int n)
    {
        int sum = 0;
        for(int i = 0;i<n;i++)
        {
            sum += arr[i];
        }

        if(sum % 2 != 0)
        {
            return false;
        }

        int target = sum/2;

        boolean[][]dp = new boolean[n+1][target+1];

        for(int i = 0;i<=n;i++)
        {
            dp[i][0] = true;
        }

        for(int i = 1;i<=n;i++)
        {
            for(int j = 1;j<=target;j++)
            {
                boolean take = false;
                boolean skip = dp[i-1][j];

                if(j>=arr[i-1])
                {
                    take = dp[i-1][j - arr[i-1]];
                }

                dp[i][j] = take || skip;
            }
        }

        return dp[n][target];

        
    }
    public boolean canPartition(int[] nums) {

        int n = nums.length;


        return canPartitionTab(nums,n);
        

        
    }
}