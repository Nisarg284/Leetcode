class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] ans = new int[nums.length];

        int mul = 1;
        int zero = 0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] != 0)
            {
                mul*=nums[i];
            }

            if(nums[i] == 0)
            {
                zero++;
            }
        }

        for(int i=0;i<nums.length;i++)
        {
            if(zero > 1)
            {
                return ans;
            }

            if(zero == 1)
            {
                if(nums[i]==0)
                {
                    ans[i] = mul;
                }
            }else{
                ans[i] = mul/nums[i];
            }
        }

        return ans;
        
    }
}