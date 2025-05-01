class Solution {

    public static boolean isEven(int a)
    {
        int x = a;
        int count = 0;

        while(x >0)
        {
            x/=10;
            count++;
        }

        return count%2 == 0 ? true:false;

    }
    public int findNumbers(int[] nums) {
        int n = nums.length;

        int count = 0;

        for(int i = 0;i<n;i++)
        {
            if(isEven(nums[i]))
            {
                count++;
            }
        }

        return count;

        
    }
}