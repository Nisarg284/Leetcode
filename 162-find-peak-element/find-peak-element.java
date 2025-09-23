class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n-1;

        while (start < end)
        {
            int mid = (start + end) /2;

            if(mid - 1 >= 0 && mid+1 < n && arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
            {
                return mid;
            }

            if(arr[mid] < arr[mid+1])
            {
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return start;
    }
}