class Solution {

    public static int helper(int prev1,int prev2,int n){

        if(n == 0 || n == 1){
            return n;
        } 

        if(prev1 != -1 && prev2 != -1){
            return prev1 + prev2;
        }

        prev1 = helper(prev1,prev2,n-1);
        prev2 = helper(prev1,prev2,n-2);

        return prev1 + prev2;
    }
    public int fib(int n) {

        if(n == 0 || n == 1){
            return n;
        }

        int prev1 = -1;
        int prev2 = -1;

        return helper(prev1,prev2,n);


        
    }
}