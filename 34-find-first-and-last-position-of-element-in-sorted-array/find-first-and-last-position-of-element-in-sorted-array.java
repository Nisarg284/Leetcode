// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int n = nums.length;
//         int i = 0;
//         int j = n-1;

//         boolean flag = false;

//         int[] ans = new int[2];

//         while( i < j)
//         {
//             int mid = (i+j)/2;
//             if(nums[mid] == target)
//             {
//                 if(mid-1 >0 && nums[mid-1] != target)
//                 {
//                     ans[0] = mid;
//                 }

//                 if(mid+1 < n && nums[mid+1] != target)
//                 {
//                     ans[1] = mid;
//                 }

//                 if(nums[n-1] == target)
//                 {
//                     ans[1] = n-1;
//                 }

//                 // if(nums[0] == target)
//                 // {
//                 //     ans[0] = 0;
//                 // }
//                 flag = true;
//             }

//             if(target < nums[mid])
//             {
//                 j--;
//             }
//             else if (target >= nums[mid])
//             {
//                 i++;
//             }
//         }

//         if(!flag)
//         {
//             ans[0] = -1;
//             ans[1] = -1;
//         }

//         return ans;

        
//     }
// }


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        
        ans[0] = findFirst(nums, target);
        ans[1] = findLast(nums, target);
        
        return ans;
    }
    
    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int first = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                first = mid; // Potential first position
                right = mid - 1; // Continue searching left
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return first;
    }
    
    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int last = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                last = mid; 
                left = mid + 1; 
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return last;
    }
}