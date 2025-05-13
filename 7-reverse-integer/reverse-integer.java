class Solution {


    public static void helper(long num,long[]ans)
    {
        if(num == 0)
        {
            return;
        }

        ans[0] *= 10;
        ans[0] += num%10;
        helper(num/10,ans);
    }


    public int reverse(int num) {

        if(num < -10 && num > 10)
        {
            return num;
        }


        long[] ans = new long[1];

        helper(num,ans);

        if(ans[0] < Integer.MIN_VALUE || ans[0] > Integer.MAX_VALUE)
        {
            return 0;
        }

        return (int)ans[0];
        
    }
}