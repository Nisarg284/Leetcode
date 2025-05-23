class Solution {
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        int currSum = nums[0];
        int maxSum = nums[0];


        for(int i = 1;i<n;i++)
        {
            int currEle = nums[i];
            currSum = Math.max(currSum + currEle , currEle );
            maxSum = Math.max(currSum,maxSum);
        }

        return maxSum;
        
    }
}