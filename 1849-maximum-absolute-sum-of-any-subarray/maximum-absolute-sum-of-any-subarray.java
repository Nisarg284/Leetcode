class Solution {
    public int maxAbsoluteSum(int[] nums) {

        int n = nums.length;

        int maxSum = nums[0];
        int currSum = nums[0];


        int minSum = nums[0];
        int currMin = nums[0];


        for(int i = 1;i<n;i++)
        {
            int curr = nums[i];

            currSum = Math.max(currSum + curr,curr);
            maxSum = Math.max(currSum,maxSum);


            currMin = Math.min(currMin + curr,curr);
            minSum = Math.min(currMin,minSum);
        }

        maxSum = Math.abs(maxSum);
        minSum = Math.abs(minSum);

        int ans = Math.max(maxSum,minSum);
        return ans;
        
    }
}