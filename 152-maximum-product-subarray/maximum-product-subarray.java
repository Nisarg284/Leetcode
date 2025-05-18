class Solution {
    public int maxProduct(int[] nums) {

        int globalMax = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];

        for(int i = 1;i<nums.length;i++)
        {
            int currMax = Math.max(nums[i] * minProd,nums[i] * maxProd);
            int currMin = Math.min(nums[i] * maxProd,nums[i]*minProd);

            maxProd = Math.max(nums[i] ,currMax);
            minProd = Math.min(nums[i],currMin);

            globalMax = Math.max(globalMax,maxProd);

        }
        
        return globalMax;
    }
}