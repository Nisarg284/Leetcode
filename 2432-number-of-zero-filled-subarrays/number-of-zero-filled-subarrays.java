class Solution {
    public long zeroFilledSubarray(int[] nums) {

        long zeroCount = 0;
        long zero = 0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == 0)
            {
                zero++;
                zeroCount+=zero;
            }else{
                zero = 0;
            }
        }
       

        return zeroCount;
        
    }
}