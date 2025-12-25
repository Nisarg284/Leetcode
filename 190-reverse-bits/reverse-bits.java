class Solution {
    public int reverseBits(int n) {

        int reverseNum = 0;

        for(int i = 0;i<32;i++)
        {
            reverseNum = reverseNum << 1;

            reverseNum += (n&1);
            n = n >> 1;
        }

        return reverseNum;
        
    }
}