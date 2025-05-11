class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {


        int i = 0;
        int n = arr.length;
        while(i < n)
        {
            int count = 0;
            while(i < n && arr[i] % 2 != 0)
            {
                count++;
                i++;
                if(count == 3)
                {
                    return true;
                }
            }
            i++;
        }

        return false;
        
    }
}