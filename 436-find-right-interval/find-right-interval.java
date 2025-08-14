class Solution {

    public static int binarySearch(int[]arr,int target,int n)
    {
        int i = 0;
        int j = n-1;

        int idx = -1;

        while(i <= j)
        {
            int mid = (i+j)/2;

            if(arr[mid] == target)
            {
                return mid;
            }

            if(arr[mid] > target)
            {
                idx = mid;
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }

        return idx;
    }

    public int[] findRightInterval(int[][] intervals) {

        int n = intervals.length;

        int[]arr = new int[n];
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i = 0;i<n;i++)
        {
            int startTime = intervals[i][0];
            hm.put(startTime,i);
            arr[i] = startTime;
        }

        Arrays.sort(arr);

        int[]ans = new int[n];

        for(int i = 0;i<n;i++)
        {
            int target = intervals[i][1];
            int idx = binarySearch(arr,target,n);

            if(idx == -1)
            {
                ans[i] = -1;
            }else{
                ans[i] = hm.get(arr[idx]);
            }
        }

        return ans;
        
    }
}