class Solution {

    public static boolean isValid(int[] arr, int m,int mid,int n)
    {
        int place = 1;
        int prev = arr[0];

        for(int i = 1;i<n;i++)
        {
            if( arr[i] - prev >= mid)
            {
                prev = arr[i];
                place++;
            }

            if(place >= m)
            {
                return true;
            }
        }
       

        return false;
    }
    public int maxDistance(int[] position, int m) {
        

        Arrays.sort(position);

        int n = position.length;

        int start = 1;
        int end = position[n-1] - position[0];

        // int ans = 0;

        while(start <= end)
        {
            int mid = start + (end - start)/2;

            if(!isValid(position,m,mid,n))
            {
                // ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return start-1;
    }
}