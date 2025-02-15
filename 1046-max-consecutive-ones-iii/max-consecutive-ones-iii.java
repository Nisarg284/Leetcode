class Solution {
    public int longestOnes(int[] nums, int k) {
        int flips = 0;
        int len = 0;
        int maxLen = Integer.MIN_VALUE;

        int i=0;
        int j=0;

        while(j<nums.length)
        {
            // move forward if nums[j] == 1
            if(nums[j] == 1)
            {
                j++;
            }else{ // nums[j] == 0

                if(flips < k)
                {
                    flips++;
                    j++;
                }else{
                    len = j-i;
                    maxLen = Math.max(len,maxLen);

                    while(nums[i]!=0)
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

        return maxLen;
        
    }
}