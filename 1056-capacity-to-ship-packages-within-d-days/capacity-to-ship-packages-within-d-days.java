class Solution {

    public static int calSum(int[]arr,int n)
    {
        int sum = 0;

        for(int i:arr)
        {
            sum+=i;
        }

        return sum;
    }

    public static boolean isValid(int[]arr,int days,int mid,int n)
    {
        int currDays = 1;
        int sum = 0;
        for(int i = 0;i<n;i++)
        {
            // if(sum == mid)
            // {
            //     currDays++;
            // }
            if(sum + arr[i] <= mid)
            {
                sum += arr[i];
            }else{
                sum = 0;
                sum+=arr[i];
                currDays++;
            }
        }

        return currDays <= days;
    }
    public int shipWithinDays(int[] weights, int days) {

        int n = weights.length;

        int i = Arrays.stream(weights).max().getAsInt();
        int j = calSum(weights,n);

        while(i <= j)
        {
            int mid = (i + j)/2;

            if(isValid(weights,days,mid,n))
            {
                j = mid-1;
            }else{
                i = mid+1;
            }
        }

        return i;
        
    }
}