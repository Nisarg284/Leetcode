class Solution {

    public static long findMin(int[] time,int n)
    {
        long min = Long.MAX_VALUE;
        for(int i = 0;i<n;i++)
        {
            min = Math.min(min,time[i]);
        }

        return min;
    }

    public static boolean isValid(int[]arr,int totalTrips,long mid,int n)
    {
        long trips = 0;

        for(int i = 0;i<n;i++)
        {
            trips += mid / arr[i];
        }

        return trips >= totalTrips ? true : false;
    }

    public long minimumTime(int[] time, int totalTrips) {

        int n = time.length;

        long start = 1;
        long end = findMin(time,n) * totalTrips;


        while(start < end)
        {
            long mid =  start + (end - start) /2;
            if(isValid(time,totalTrips,mid,n))
            {
                end = mid;
            }else{
                start = mid+1;
            }
        }

        // System.out.println("start: "+start+" end: "+end);

        return start;



// Brute force Approach

        // int n = time.length;
        // // int count = 0;
        // int ti = 1;

        // while(true)
        // {
        //     int trips = 0;
        //     for(int i = 0;i<n;i++)
        //     {
        //         // if(totalTrips <= 0)
        //         // {
        //         //     return ti;
        //         // }
        //         trips += ti/ time[i];
        //         if(trips>=totalTrips)
        //         {
        //             break;
        //         }
        //         System.out.print(trips+" ");
        //     }
        //     if(trips>=totalTrips)
        //     {
        //         break;
        //     }
        //     System.out.println();
        //     ti++;
        // }

        // return ti;

        
        
    }
}