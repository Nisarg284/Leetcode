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

        // for(int i = 0;i<=n;i++)
        // {
        //     ans[i] = bitCounter(i);
        // }

        for(int i = 1;i<=n;i++)
        {
            int prevAns = i >> 1;
            ans[i] = ans[prevAns] + (i & 1);
        }

        return ans;
    }
}