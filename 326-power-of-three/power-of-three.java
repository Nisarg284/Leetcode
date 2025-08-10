class Solution {

    public static boolean helper(int n,int pow,long num)
    {
        if(num == n)
        {
            return true;
        }

        if(num > n)
        {
            return false;
        }

        return helper(n,pow+1,(long)Math.pow(3,pow));
    }
    public boolean isPowerOfThree(int n) {
        if(n == 1)
        {
            return true;
        }

        return helper(n,1,3);

        
        
    }
}