class Solution {
    public int candy(int[] rankings) {

    //    int n = ratings.length;
       

    //    // create new array for left to right
    //    int[] lToR = new int[n];

    //    // create new array for right to left
    //    int [] rToL = new int[n];

    //    // intsert 1 in both array
    //    Arrays.fill(lToR,1);
    //    Arrays.fill(rToL,1);

    //    // give an extra candy if current rating < previous rating
    //    for(int i=0;i<n-1;i++)
    //    {
    //     if(ratings[i]>ratings[i+1])
    //     {
    //         lToR[i] = lToR[i+1]+1;
    //     }
    //    }

    //    // right to left
    //    for(int i=n-1;i>0;i--)
    //    {
    //     if(ratings[n-1] > ratings[n-2])
    //     {
    //         rToL[i] = rToL[i-1]+1;
    //     }
    //    }

    //     int candyCount =0;

    //     int[] candy = new int[n];
        

    //     for(int i =0;i<n;i++)
    //     {
    //         if(lToR[i] > rToL[i])
    //         {
    //             candy[i]=lToR[i];
    //         }
    //         else{
    //             candy[i]=rToL[i];
    //         }
    //     }

    //     for(int i=0;i<n;i++)
    //     {
    //         candyCount+=candy[i];
    //     }
    //     return candyCount;
    //    }



        int n = rankings.length;
        int []lToR = new int[n];

        int []rToL = new int[n];

        Arrays.fill(lToR,1);
        Arrays.fill(rToL,1);


        for(int i=1;i<n;i++)
        {
            if(rankings[i] > rankings[i-1])
            {
                lToR[i] = lToR[i-1]+1;

            }
        }

        for(int i=n-2;i>=0;i--)
        {
            if(rankings[i] > rankings[i+1])
            {

               rToL[i] = rToL[i+1]+1;
            }
        }


        int [] total = new int[n];
        for(int i=0;i<n;i++)
        {
            total[i] = Math.max(lToR[i],rToL[i]);
        }

        int totalcandies = 0;
        for(int i=0;i<n;i++)
        {
            totalcandies +=total[i];
        }

            return totalcandies;


        // int n = rankings.length;

        // int[]arr = new int[n];
        // Arrays.fill(arr,1);

        // int need = 0;

        // for(int i = 1;i<n-1;i++)
        // {
        //     int prev = rankings[i-1];
        //     int next = rankings[i+1];

        //     int curr = rankings[i];

        //     if((curr == prev && curr == next) || (curr < prev && curr < next))
        //     {
        //         need+= arr[i];
        //         continue;
        //     }

        //     if( (curr > prev && curr > next) || curr > prev)
        //     {
        //         arr[i] = arr[i-1] + 1;
        //         need += arr[i];
        //     }else{
        //         arr[i] = arr[i+1] + 1;
        //         need += arr[i];
        //     }
        // }

        // if(rankings[n-1] > rankings[n-2])
        // {
        //     arr[n-1] = arr[n-2] + 1;
        //     need += arr[n-1];
        // }else{
        //     need += arr[n-1];
        // }

        // if(rankings[0] > rankings[1])
        // {
        //     arr[0] = arr[1] + 1;
        //     need+= arr[0];
        // }


        // need = 0;
        // for(int i = 0;i<n;i++)
        // {
        //     need += arr[i];
        //     System.out.print(need +" ");
        // }

        // return need;


    }
}
