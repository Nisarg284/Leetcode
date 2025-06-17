class Solution {

    public static boolean helper(int[]nums,int idx,int n,int target,Boolean[][] memo)
    {
        if(idx == n)
        {
            return target == 0;
        }

        if(memo[idx][target] != null)
        {
            return memo[idx][target];
        }

        if(target == 0)
        {
            return true;
        }

        boolean exclude = helper(nums,idx+1,n,target,memo);
        boolean include = false;


        if(target >= nums[idx])
        {
            include = helper(nums,idx+1,n,target - nums[idx],memo);
        }

        // boolean include = helper(nums,idx+1,n,target - nums[idx],memo);
        // boolean exclude = helper(nums,idx+1,n,target,memo);

        memo[idx][target] = include || exclude;

        return memo[idx][target];



        // return include || exclude;
    }

    public boolean canPartition(int[] nums) {

        int n = nums.length;
        int sum = 0;

        for(int i = 0;i<n;i++)
        {
            sum+=nums[i];
        }

        if(sum % 2 != 0)
        {
            return false;
        }


        // Boolean[][] memo = new Boolean[n][target+1];

        int target = sum / 2;

        Boolean[][] memo = new Boolean[n][target+1];


        return helper(nums,0,n,target,memo);
        
    }
}