class Solution {
    public int maxAbsoluteSum(int[] nums) {

        int currMax = 0;
        int maxSum = 0;

        int currMin = 0;
        int minSum = 0;

        for(int i = 0;i<nums.length;i++)
        {
            currMax = Math.max(nums[i],currMax + nums[i]);
            maxSum = Math.max(currMax,maxSum);

            currMin = Math.min(nums[i],nums[i] + currMin);
            minSum = Math.min(currMin,minSum);
        }

        return Math.max(Math.abs(maxSum),Math.abs(minSum));
        
    }
}