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

        return helper(n,pow+1,(long)Math.pow(2,pow));
    }
    public boolean isPowerOfTwo(int n) {
        if(n == 1)
        {
            return true;
        }

        return helper(n,1,2);

        
        
    }
}