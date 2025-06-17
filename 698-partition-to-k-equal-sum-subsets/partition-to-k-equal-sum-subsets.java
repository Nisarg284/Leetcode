// class Solution {
//     public boolean canPartitionKSubsets(int[] nums, int k) {
//         int n = nums.length; 

//         int sum = 0;

//         for(int i =0;i<n;i++)
//         {
//             sum+=nums[i];
//         }

//         int target = sum/k;

//         if((sum%2 == 0 && k%2 != 0 ) || (sum %2 != 0 && k%2 == 0))
//         {
//             return false;
//         }

//         boolean dp[][] = new boolean[n+1][target+1];

//         for(int i = 0;i<=n;i++)
//         {
//             dp[i][0] = true;
//         }

//         for(int i=1;i<=n;i++)
//         {
//             for(int j=1;j<=target;j++)
//             {
//                 if(nums[i-1] <= j)
//                 {
//                     boolean accept = dp[i-1][j-nums[i-1]];
//                     boolean reject = dp[i-1][j];

//                     dp[i][j] = accept || reject;
//                 }else{
//                     dp[i][j] = dp[i-1][j];
//                 }
//             }
//         }

//         return dp[n][target];
        
//     }
// }


class Solution{


    public static boolean helper(int[]nums, int n, int idx, int currSum, int targetSum, int k, HashSet<Integer>hs)
    {
        if(k == 0)
        {
//            System.out.println(hs);
            return hs.size() == n;
        }

        if(currSum  == targetSum)
        {
            // System.out.println(hs);
            return helper(nums, n, 0, 0, targetSum, k-1, hs);
        }

        for(int i = idx;i<n;i++)
        {
            if(!hs.contains(i) && currSum + nums[i] <= targetSum)
            {
                hs.add(i);
                boolean check = helper(nums, n, i+1, currSum+nums[i], targetSum, k, hs);

                if(check)
                {
                    return true;
                }
                hs.remove(i);
            }
        }

        return false;



    }

    public boolean canPartitionKSubsets(int[] nums, int k) {

        int n = nums.length;
        int sum = 0;
        for(int i : nums)
        {
            sum += i;
        }

        if(sum % k != 0)
        {
            return false;
        }

        int target = sum / k;

        // boolean[] vis = new boolean[n];

        for(int i = 0;i<n;i++)
        {
            if(nums[i] > target)
            {
                return false;
            }
        }

         return helper(nums,n,0, 0, target, k, new HashSet<>());
    }

}