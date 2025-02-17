class Solution {

    public static double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double pow = helper(x, n / 2);

        if (n % 2 == 0) {
            return pow * pow;
        }

        return x * pow * pow;
    }

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        

        return helper(x,n);

    }
}