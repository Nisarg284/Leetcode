// class Solution {
//     public long countSubarrays(int[] nums, int k) {

//         int max = 0;
//         int n = nums.length;
//         for(int i = 0;i<n;i++)
//         {
//             max = Math.max(max,nums[i]);
//         }

//         int i = 0;
//         int j = 0;

//         int count = 0;
//         int freq = 0;

//         while(j<n)
//         {
//             if(nums[j] == max)
//             {
//                 freq++;
//             }

//             if(freq >= k)
//             {
//                 while(i<j && freq >=k)
//                 {
//                     if(nums[i] == max)
//                     {
//                         freq--;
//                     }
//                     count++;
//                     i++;
//                 }
//             }
//             j++;


//         }

//         return count;
        
//     }
// }


class Solution {
    public long countSubarrays(int[] nums, int k) {
        // Find maximum element
        int max = 0;
        for(int num : nums) {
            max = Math.max(max, num);
        }
        
        long count = 0;
        int freq = 0;
        int i = 0;
        
        // Slide window
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] == max) {
                freq++;
            }
            
            // Shrink window if freq exceeds k
            while(freq >= k) {
                // For each valid window ending at j,
                // count subarrays from i to j
                count += (nums.length - j);
                if(nums[i] == max) {
                    freq--;
                }
                i++;
            }
        }
        
        return count;
    }
}