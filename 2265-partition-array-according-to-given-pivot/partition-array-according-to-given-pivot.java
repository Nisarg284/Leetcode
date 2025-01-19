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


class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        // Lists to collect elements
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        // Classify elements in one pass
        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                greater.add(num);
            }
        }

        // Merge the three lists
        int[] result = new int[nums.length];
        int index = 0;

        for (int num : less) {
            result[index++] = num;
        }
        for (int num : equal) {
            result[index++] = num;
        }
        for (int num : greater) {
            result[index++] = num;
        }

        return result;
    }
}
