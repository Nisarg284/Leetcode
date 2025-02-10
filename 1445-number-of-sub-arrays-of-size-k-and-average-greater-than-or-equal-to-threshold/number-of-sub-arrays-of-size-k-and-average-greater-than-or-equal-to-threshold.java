class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int sum = 0;
        int count = 0;

        for(int i=0;i<k;i++)
        {
            sum+=arr[i];
        }

        int avg = sum/k;

        if(avg >= threshold)
        {
            count++;
        }

        int i=1;
        int j = i+k-1;

        while(j<arr.length)
        {
            sum+= arr[j] - arr[i-1];

             avg = sum/k;

            if(avg >= threshold)
            {
                count++;
            }
            i++;
            j++;
        }

        return count;
        
    }
}