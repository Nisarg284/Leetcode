class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] mergeArr = new int[m+n];

        int i=0;
        int j=0;
        int k=0;
        

        while(i < m && j < n)
        {
            
               if(nums1[i] < nums2[j] )
               {
                mergeArr[k] = nums1[i];
                k++;
                i++;
               }
            else 
            {
                mergeArr[k] = nums2[j];
                k++;
                j++; 
            }
        }

        while( i < m)
        {
                mergeArr[k] = nums1[i];
                k++;
                i++;
        }

        while( j < n)
        {
                
                mergeArr[k] = nums2[j];
                k++;
                j++;
        }

        System.arraycopy(mergeArr, 0, nums1, 0, m + n);

        // if(j < nums2.length)
        // {
        //     for(int a = j;a<nums2.length;a++)
        //     {
        //         mergeArr[k] = nums2[a];
        //         k++;
                
        //     }
        // }

       // int[] ans = new int[li.size()];

        // for(int a=0;a<mergeArr.length;a++)
        // {
        //     nums1[a]=mergeArr[a]; 
        // }
        
    }
}