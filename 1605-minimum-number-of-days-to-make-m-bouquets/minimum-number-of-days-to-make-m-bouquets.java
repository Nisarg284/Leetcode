class Solution {

    public static boolean isValid(int mid,int bouquet,int flowersInOne,int[]arr,int n)
    {
        int made = 0;
        int count = 0;

        for(int i = 0 ;i<n;i++)
        {
            if(arr[i] <= mid)
            {
                count++;
                if(count == flowersInOne)
                {
                    made++;
                    count = 0;
                }
            }else{
                count = 0;
            }
        }

        return made >= bouquet;
    }
    public int minDays(int[] arr, int m, int k) {
        int n = arr.length;

        if(m * k > n)
        {
            return -1;
        }


        int start = Arrays.stream(arr).min().getAsInt();
        int end = Arrays.stream(arr).max().getAsInt();

        int ans = -1;

        while(start <= end)
        {   
            int mid = start + (end - start)/2;

            // System.out.println("mid --> "+mid);

            if(isValid(mid,m,k,arr,n))
            {
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return ans;
        
    }
}