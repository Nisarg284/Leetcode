class Solution {
     public int longestMonotonicSubarray(int[] nums) {

        int maxCount = 1;
        int count = 1;

        for(int i=0;i<nums.length-1;i++)
        {
            int j = i+1;

            if(nums[i] < nums[j])
            {
                count++;
            }else{
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }

        for(int i = nums.length-1;i>0;i--)
        {
            int j=i-1;

            if(nums[i] < nums[j])
            {
                count++;
            }
            else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }

        maxCount = Math.max(count,maxCount);
        
        return maxCount;
        

    }
}