class Solution {
    public int hammingWeight(int n) {


        int counter = 0;

        while(n != 0)
        {
            int bitMask = 1;

            int lsb = (n & bitMask);

            if(lsb == 1)
            {
                counter++;
            }

            n = n>>1;
        }

        return counter;
        
    }
}