class Solution {
    public int maxSubArray(int[] nums) {


        int maxSum = nums[0];
        int currSum = nums[0];
        int n = nums.length;


        for(int i = 1;i<n;i++)
        {
            int curr = nums[i];

            currSum = Math.max(currSum + curr,curr);
            maxSum = Math.max(maxSum , currSum);
        }

        return maxSum;
        
    }
}