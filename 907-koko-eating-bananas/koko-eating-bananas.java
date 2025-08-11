class Solution {

    // public static int findMax(int[]arr,int n)
    // {
    //     int max = arr[0];
    //     for(int i : arr)
    //     {
    //         max = Math.max(max,i);
    //     }

    //     return max;
    // }

    // public static boolean canEat(int[]arr,int n,int mid,int h)
    // {
    //     int hrs = 0;

    //     for(int i:arr)
    //     {
    //         hrs += (i + mid - 1) / mid;
    //     }

    //     // System.out.println(hrs+" mid: "+mid);

    //     return hrs <= h;
    // }
    // public int minEatingSpeed(int[] piles, int h) {

    //     int n = piles.length;

    //     int start = 1;
    //     int end  = findMax(piles,n);


    //     while(start < end)
    //     {
    //         int mid = (start + end) / 2;

    //         if(canEat(piles,n,mid,h))
    //         {
    //             end = mid;
    //         }else{
    //             start = mid + 1;
    //         }
    //     }


    //     return start;
        
    // }


      public static int findMax(int[]arr)
    {
        int max = Integer.MIN_VALUE;
        for (int i : arr)
        {
            max = Math.max(i,max);
        }

        return max;
    }

    public static boolean isValid(int[]arr,int mid,int hrs)
    {
        int time = 0;

        for(int i = 0 ;i<arr.length;i++)
        {
//            time += (arr[i] / mid)+1;
            if(arr[i] % mid == 0)
            {
                time += (arr[i]/mid);
            }else{
                time += (arr[i]/mid)+1;
            }

        }

        return time <= hrs;
    }

    public static int minEatingSpeed(int[]piles,int hrs)
    {
        int n = piles.length;

        int i = 1;
        int j = findMax(piles);

        while( i < j)
        {
            int mid = (i + j)/2;

            if(isValid(piles,mid,hrs))
            {
                j = mid;
            }else{
                i = mid+1;
            }
        }

        return i;
    }
}