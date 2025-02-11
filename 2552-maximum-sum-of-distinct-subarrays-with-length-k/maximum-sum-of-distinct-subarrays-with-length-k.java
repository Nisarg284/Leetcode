class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        if(nums.length < k)
        {
            return 0;
        }

        HashSet<Integer> hs = new HashSet<>();
        long maxSum = 0;
        long sum = 0;

        int i=0;
        int j=0;

        while(j<nums.length)
        {
            while(hs.contains(nums[j]))
            {
                hs.remove(nums[i]);
                sum-=nums[i];
                i++;
            }

            hs.add(nums[j]);
            sum+=nums[j];

            if( j-i+1 == k)
            {
                maxSum = Math.max(maxSum , sum);
                hs.remove(nums[i]);
                sum -= nums[i];
                i++;
                
            }
            j++;
        }

        return maxSum;
        
    }
}