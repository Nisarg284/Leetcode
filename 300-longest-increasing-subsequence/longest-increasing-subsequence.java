class Solution {
    public int lengthOfLIS(int[] nums) {

        // define TreeSet for sorting & extracting unique Elements from given array
        TreeSet<Integer> uniqueSet = new TreeSet<>();

        // add given array elements into set
        for(int i=0;i<nums.length;i++)
        {
            uniqueSet.add(nums[i]);
        }

        // create new array which contains sorted & unique elements
        int[] nums1 = new int[uniqueSet.size()];
        int i=0; // iterator

        for(Integer st: uniqueSet)
        {
            nums1[i] = st;
            i++;
        }

        // define new DP array
        int dp[][] = new int[nums1.length+1][nums.length+1];

        int n = dp.length;
        int m = dp[0].length;

        // fill dp array
        for(i=1;i<n;i++)
        {
            for(int j=1;j<m;j++)
            {
                // if both num is same
                if(nums1[i-1] == nums[j-1])
                {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{ // num is not same

                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n-1][m-1];
        
    }
}