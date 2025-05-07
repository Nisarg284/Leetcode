class Solution {
    public int arrangeCoins(int n) {

        int level = 1;

        int temp = n;


        for(int i = 1;i<=n;i++)
        {
            temp-=i;
            if(temp < 0)
            {
                level = i-1;
                break;
            }
        }

        return level;
        
    }
}