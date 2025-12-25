class Solution {

    public int bitCounter(int num)
    {
        int count = 0;
        while(num != 0)
        {
            int bitMask = (num & 1);
            if(bitMask == 1)
            {
                count++;
            }
            num = num>>1;
        }

        return count;
    }


    public int[] countBits(int n) {
        

        int[] ans = new int[n+1];

        for(int i = 0;i<=n;i++)
        {
            ans[i] = bitCounter(i);
        }

        return ans;
    }
}