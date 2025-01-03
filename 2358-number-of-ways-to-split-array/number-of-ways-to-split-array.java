class Solution {
    public int waysToSplitArray(int[] nums) {

        long totalSum =0;
        int count = 0;

        for(int i=0;i<nums.length;i++)
        {
            totalSum += nums[i];
        }

            long leftSum =0;
            long rightSum = 0;
           
        for(int i=0;i<nums.length-1;i++)
        {
            leftSum += nums[i];
            rightSum = totalSum-leftSum;

            if(leftSum >= rightSum)
            {
                count++;
            }

        }

        return count;



        // int count = 0;

        // int leftSum = 0;
        // int rightSum = 0;

        // for(int i=0;i<nums.length-1;i++)
        // {
        //     leftSum += nums[i];
            
        //     for(int j=i+1;j<nums.length;j++)
        //     {
        //         rightSum+=nums[j];
        //     }
            
        //     if(leftSum >= rightSum)
        //     {
        //         count++;
        //     }
        //     rightSum = 0;
        // }

        // return count;
        
    }
}