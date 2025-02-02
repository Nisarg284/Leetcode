class Solution {
    public boolean check(int[] nums) {

        boolean flag = true;
        for(int i=0;i<nums.length-1;i++)
        {
            int j = i+1;
            if(nums[i] > nums[j] && flag ==  false)
            {
                return false;
            }
            else if(nums[i] > nums[j])
            {
                flag =  false;
            }
        }

        if(flag == false)
        {
            if(nums[0] >= nums[nums.length-1])
            {
                return true;
            }
        }
        return flag;
        
    }
}