class Solution
{
    public int[] pivotArray(int[] nums, int pivot)
    {
        int ans[] = new int [nums.length];
        int j=0;
        int n=nums.length;

        for(int i=0;i<n;i++)
        {
            if(nums[i] < pivot)
            {
                ans[j] = nums[i];
                j++;
            }
        }

        for(int i=0;i<n;i++)
        {
            if(nums[i] == pivot)
            {
                ans[j] = nums[i];
                j++;
            }
        }

        for(int i=0;i<n;i++)
        {
            if(nums[i] > pivot)
            {
                ans[j] = nums[i];
                j++;
            }
        }

        return ans;
    }

}



// class Solution {

//     public static int findIndex(int[] nums, int pivot)
//     {
//         int count = 0;
//         for(int i=0;i<nums.length;i++)
//         {
//             if(nums[i] < pivot)
//             {
//                 count++;
//             }
//         }
//         return count; 
//     }

//     public static int saathiIdx(int[] nums, int pivot)
//     {
//         for(int i=0;i<nums.length;i++)
//         {
//             if(nums[i]==pivot)
//             {
//                 return i;
//             }
//         }
//         return -1;
//     }

//     public static void swapElements(int[] nums,int i,int j)
//     {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
//     public int[] pivotArray(int[] nums, int pivot) {

//         if(nums.length == 0)
//         {
//             return nums;
//         }

//         // correct position of pivot 
//         int pivotIdx = findIndex(nums,pivot);
//         int saathi = saathiIdx(nums,pivot);

//         if (saathi == -1) {
//             return nums; 
//         }

//         // swap elements of pivotIdx to saathiIdx
//         swapElements(nums,pivotIdx,saathi);

//         int i=0;
//         int j=nums.length-1;

//        while(i < pivotIdx && j>pivotIdx)
//        {
//         if(nums[i] <= nums[pivotIdx])
//         {
//             i++;
//         }
//         else if(nums[j] > nums[pivotIdx])
//         {
//             j--;
//         }else if(nums[i] >= nums[pivotIdx] && nums[j] < nums[pivotIdx])
//         {
//             // int temp = nums[i];
//             // nums[i] = nums[j];
//             // nums[j] = temp;
//             swapElements(nums,i,j);
//             i++;
//             j--;
//         }

//        }

//        return nums;
        
//     }
// }



