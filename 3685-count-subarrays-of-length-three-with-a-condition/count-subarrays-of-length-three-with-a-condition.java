// class Solution {
//     public int countSubarrays(int[] nums) {

//         if(nums.length < 3)
//         {
//             return -1;
//         }

//         int i = 0;
//         int j = i+2;
//         int count = 0;

//         while(j<nums.length)
//         {
//             int sum = nums[i] + nums[j];
//             int half = nums[i+1]/2;
//             if(sum == half && half %2 == 0)
//             {
//                 count++;
//             }
//             i++;
//             j++;
//         }

//         return count;
        
//     }
// }


class Solution {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i <= n - 3; i++) {
            int first = nums[i];
            int second = nums[i + 1];
            int third = nums[i + 2];

            if (first + third == second / 2 && second % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}
