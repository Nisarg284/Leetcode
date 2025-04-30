class Solution {
    public long countSubarrays(int[] nums, int k) {

        int max = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++)
        {
            max = Math.max(max,nums[i]);
        }

        int i = 0;
        int j = 0;

        long count = 0;
        int freq = 0;

        while(j<n)
        {
            if(nums[j] == max)
            {
                freq++;
            }

            
                while(freq >=k)
                {
                    count += (n-j);
                    if(nums[i] == max)
                    {
                        freq--;
                    }
                    i++;
                }
            j++;


        }

        return count;
        
    }
}

