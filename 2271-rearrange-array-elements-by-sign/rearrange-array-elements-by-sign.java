class Solution {
    public int[] rearrangeArray(int[] nums) {

        // int n = nums.length;
        int [] ans = new int[nums.length];

        int p=0;
        int n=1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] > 0)
            {
                ans[p] = nums[i];
                p+=2;
            }else{
                ans[n] = nums[i];
                n+=2;
            }
        }
        return ans;



        // int n= nums.length;
        // int[] positive = new int[n/2];
        // int[] negative = new int[n/2];

        // int j=0;
        // int k=0;

        // for(int i=0;i<nums.length;i++)
        // {
        //     if(nums[i] >  0)
        //     {
        //         positive[j] = nums[i];
        //         j++;
        //     }else{
        //         negative[k] = nums[i];
        //         k++;
        //     }
        // }

        // k=0;
        // int i=0;
        // j=0;
        // while(k < n)
        // {
        //     if(k%2==0)
        //     {
        //         nums[k] = positive[i];
        //         i++;
        //         k++;
        //     }else{
        //         nums[k] = negative[j];
        //         j++;
        //         k++;
        //     }
        // }

        // return nums;
        
    }
}