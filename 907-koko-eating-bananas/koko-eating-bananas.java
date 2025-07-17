class Solution {

    public static int findMax(int[]arr,int n)
    {
        int max = arr[0];
        for(int i : arr)
        {
            max = Math.max(max,i);
        }

        return max;
    }

    public static boolean canEat(int[]arr,int n,int mid,int h)
    {
        int hrs = 0;

        for(int i:arr)
        {
            hrs += (i + mid - 1) / mid;
        }

        // System.out.println(hrs+" mid: "+mid);

        return hrs <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {

        int n = piles.length;

        int start = 1;
        int end  = findMax(piles,n);


        while(start < end)
        {
            int mid = (start + end) / 2;

            if(canEat(piles,n,mid,h))
            {
                end = mid;
            }else{
                start = mid + 1;
            }
        }


        return start;
        
    }
}