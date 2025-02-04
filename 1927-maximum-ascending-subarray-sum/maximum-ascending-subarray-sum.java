class Solution {
    public int maxAscendingSum(int[] nums) {

        int i=0;
        int n = nums.length;
        int maxSum = 0;
        int sum = 0;

        while(i<n )
        {
            if(i==n-1)
            {
                sum+=nums[i];
                maxSum = Math.max(maxSum,sum);
                i++;
            }else{
                if(nums[i] < nums[i+1])
                {
                    sum+=nums[i];
                    i++;
                }else{
                    sum+=nums[i];
                    maxSum = Math.max(maxSum,sum);
                    sum = 0;
                    i++;
                }
            }
        }

        return maxSum;
        
    }
}