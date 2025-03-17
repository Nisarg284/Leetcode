class Solution {
    public int maxSum(int[] nums) {

        HashSet<Integer> hs = new HashSet<>();
        int max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] > 0)
            {
                hs.add(nums[i]);
            }
            max = Math.max(nums[i],max);
        }

        if(max < 0)
        {
            return max;
        }

        int ans = 0;
        for(int i:hs)
        {
            ans+=i;
        }

        return ans;
        
    }
}