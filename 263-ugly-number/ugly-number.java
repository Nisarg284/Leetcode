class Solution {
    public boolean isUgly(int n) {

        if(n==1)
        {
            return true;
        }

        if( n==0)
        {
            return false;
        }

        // System.out.print(n+" ");

        boolean a = false;
        boolean b = false;
        boolean c = false;

        if(n % 2==0)
        {
            a = isUgly(n/2);
        }

        if(n % 3 == 0)
        {
            b = isUgly(n/3);
        }

        if(n % 5 == 0)
        {
            b = isUgly(n/5);
        }



        return a || b || c;
    }
}