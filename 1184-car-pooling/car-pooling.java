class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        

        int n = trips.length;

        Arrays.sort(trips,(a,b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        int passangers = trips[0][0];

        if(passangers > capacity)
        {
            return false;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2] - b[2]);
        pq.add(trips[0]);

        for(int i = 1;i<n;i++)
        {

            int currStart = trips[i][1];
            int currPass = trips[i][0];

            // int prevEnd = pq.peek()[2];

            while(!pq.isEmpty() && pq.peek()[2] <= currStart )
            {
                // int prevEnd = pq.peek()[2];
                int prevPess = pq.peek()[0];
                passangers -= prevPess;
                pq.remove();
            }
            
            pq.add(trips[i]);
            passangers += currPass;
            if(passangers > capacity)
            {
                return false;
            }

        //     int prevEnd = trips[i-1][2];
        //     int currStart = trips[i][1];
        //     int prevPess = trips[i-1][0];
        //     int currPess = trips[i][0];


        // if(prevEnd > currStart)
        // {
        //     int totalPassangers = prevPess + currPess;
        //     if(totalPassangers > capacity)
        //     {
        //         return false;
        //     }

        // }

        }

        return true;


    }
}