class Solution {

    public static int findMin(int[] arr)
    {
        int min = Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++)
        {
            min = Math.min(min,arr[i]);
        }

        return min;
    }
    public int minNumber(int[] nums1, int[] nums2) {

        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<nums1.length;i++)
        {
            hs.add(nums1[i]);
        }

        int ans = Integer.MAX_VALUE;

        for(int i=0;i<nums2.length;i++)
        {
            if(hs.contains(nums2[i]))
            {
                ans = Math.min(nums2[i],ans);
            }else{
                 hs.add(nums2[i]);
            }
           
        }

        if(hs.size() < nums1.length + nums2.length)
        {
            return ans;
        }

        int min1 = findMin(nums1);
        int min2 = findMin(nums2);

        int min = Math.min(min1,min2);
        int max = Math.max (min1,min2);


        return (min*10) + max;
        
    }
}