class Solution {
    public int longestSubarray(int[] nums) {

        int i=0;
        int j=0;
        int k = 1;

        int flips = 0;

        int len = 0;
        int maxLen = Integer.MIN_VALUE;

        while(j < nums.length)
        {
            if(nums[j] == 1)
            {
                j++;
            }else{
                if(flips<k)
                {
                    flips++;
                    j++;
                }else{

                    len  = j-i;
                    maxLen = Math.max(len,maxLen);
                    while(nums[i] !=0)
                    {
                        i++;
                    }
                    i++;
                    j++;
                }
            }
        }

        len = j-i;
        maxLen = Math.max(len,maxLen);

        return maxLen-1;
        
    }
}