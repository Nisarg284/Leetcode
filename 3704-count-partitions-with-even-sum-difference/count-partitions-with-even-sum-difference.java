class Solution {
    public int countPartitions(int[] nums) {

        int total =0;
        for(int i=0;i<nums.length;i++)
        {
            total+=nums[i];
        }

        int count = 0;
        int leftSum = 0;
        for(int i=0;i<nums.length-1;i++)
        {
            leftSum+=nums[i];
            int rightSum = total - leftSum;

            if((leftSum%2 == 0 && rightSum%2 == 0) || (leftSum % 2!=0 && rightSum%2!=0))
            {
                count++;
            }
        }

        return count;
        
    }
}