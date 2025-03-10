class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hs = new HashSet<>();

        while( n!=1 && !hs.contains(n))
        {
            hs.add(n);
            n = helper(n);
        }

        return n==1;
        
    }

   private int helper(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n /= 10;
        }
        return totalSum;
    }
}