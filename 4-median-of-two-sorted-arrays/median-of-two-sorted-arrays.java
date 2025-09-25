class Solution {
    public static void mergeArray(int[] nums1, int[] nums2,int[]merge)
    {
        int i=0;
        int j=0;
        int k=0;

        
        while(i != nums1.length && j != nums2.length)
        {
            if(nums1[i] < nums2[j] )
            {
                merge[k] = nums1[i];
                i++;
                k++;
            }
            else{
                 merge[k] = nums2[j];
                j++;
                k++;
            }
        }

        if(i < nums1.length)
        {
            for(int a = i;a<nums1.length;a++)
            {
                merge[k] = nums1[a];
                k++;
                i++;
            }
        }

        if(j < nums2.length)
        {
            for(int a = j;a<nums2.length;a++)
            {
                merge[k] = nums2[a];
                k++;
                j++;
            }
        }



    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double ans = 0;


        // when nums1 array is empty
        // if(nums1.length == 0)
        // {
        //     if(nums2.length %2 != 0)
        // {
        //     return nums2[nums2.length/2];
        // }
        // else{
        //     int mid = nums2.length/2;
        //     return (nums2[mid-1] + nums2[mid])/2.0;
        // }
        // }


        // // when nums2 array is empty
        //  if(nums2.length == 0)
        // {
        //     if(nums1.length %2 != 0)
        // {
        //     return nums1[nums1.length/2];
        // }
        // else{
        //     int mid = nums1.length/2;
        //     return (nums1[mid-1] + nums1[mid])/2.0;
        // }
        // }


        // if(nums1.length == 1 && nums2.length == 0 )
        // {
        //     return nums1[0];
        // }

        // if(nums2.length == 1 && nums1.length == 0 )
        // {
        //     return nums2[0];
        // }

        int[] merge = new int[nums1.length + nums2.length];

        mergeArray(nums1,nums2,merge);

        

        if(merge.length %2 != 0)
        {
            ans = merge[merge.length/2];
        }else{
            int mid = merge.length/2;
            ans = (merge[mid-1] + merge[mid])/2.0;
        }


        return ans;
        
    }
}