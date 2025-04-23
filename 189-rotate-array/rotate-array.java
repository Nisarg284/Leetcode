// class Solution {
//     public void rotate(int[] nums, int k) {

//         int[]ans = new int[nums.length];

//         int j=0;

        

//         for(int i=nums.length-k;i<nums.length;i++)
//         {
//             ans[j] = nums[i];
//             j++; 
//         }

//         for(int i=0;i<=k;i++)
//         {
//             ans[j] = nums[i];
//             j++;
//         }

//         for(int i=0;i<ans.length;i++)
//         {
//             nums[i] = ans[i];
//         }
        
//     }
// }


class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = rotated[i];
        }        
    }
}