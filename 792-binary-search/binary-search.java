class Solution {
    public int search(int[] arr, int target) {
         int i=0;
        int j=arr.length-1;
        int mid;

        while(i<=j)
        {
            mid = (i+j)/2;

            if(arr[mid] == target)
            {
                return mid;
            } else if (arr[mid] < target) {
                i = mid+1;
            }else {
                j = mid-1;
            }
        }
        return -1;
        
    }
}