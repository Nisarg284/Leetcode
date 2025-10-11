class Solution {

    public static int helper(int idx,int target,int arr[])
    {
        // if(idx == 0)
        // {
        //     if(arr[idx] == target || target - arr[idx] == 0 )
        //     {
        //         return 1;
        //     }
        //     return 0;
        // }

        if(idx < 0)
        {
            if(target == 0)
            {
                return 1;
            }

            return 0;
        }

        int plus = helper(idx-1,target - arr[idx],arr);
        int minus = helper(idx-1,target + arr[idx],arr);

        return plus + minus;
    }
    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;

        return helper(n-1,target,nums);
        
    }
}