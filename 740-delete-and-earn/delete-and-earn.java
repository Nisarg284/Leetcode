class Solution {
    
    public static int helper(int idx,int[] arr,int[]dp)
    {
        if(idx < 0)
        {
            return 0;
        }

        if(dp[idx] != 0)
        {
            return dp[idx];
        }

        int take = arr[idx] + helper(idx-2,arr,dp);
        int skip = helper(idx-1,arr,dp);

        return dp[idx] = Math.max(take,skip);

    }

    public int deleteAndEarn(int[] nums) {

        if(nums.length == 1)
        {
            return nums[0];
        }
        int maxEle = Arrays.stream(nums)
                                .max().getAsInt();

        int[] sumArray = new int[maxEle+1];
        for(int i = 0;i<nums.length;i++)
        {
            sumArray[nums[i]]+=nums[i];
        }


        int[]dp = new int[maxEle+1];
        dp[0] = sumArray[0];
        dp[1] = Math.max(sumArray[0],sumArray[1]);

        // helper(maxEle,sumArray,dp);

        return helper(maxEle,sumArray,dp);
    }
}