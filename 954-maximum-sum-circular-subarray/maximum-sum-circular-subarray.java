class Solution {

    public int maxSubarraySumCircular(int[] nums) {

        int maxSum = nums[0];
        int currMaxSum = nums[0];
        int minSum = nums[0];
        int currMinSum = nums[0];
        int total = nums[0];

        for(int i=1;i<nums.length;i++)
        {
            total += nums[i];
            currMinSum = Math.min(currMinSum + nums[i],nums[i]);
            minSum = Math.min(minSum , currMinSum); 

            currMaxSum = Math.max(currMaxSum + nums[i] , nums[i]);
            maxSum = Math.max(maxSum , currMaxSum);
        }

        if (total == minSum) {
            return maxSum;
        }


        maxSum = Math.max(total - minSum,maxSum);
        return maxSum;
        
    }
}

// class Solution {
// public static int maxSubarraySumCircular(int[] arr) {
//     if (arr.length == 0) return 0;

//     int totalSum = 0;
//     int currMin = arr[0];
//     int minSum = arr[0];
//     int currMax = arr[0];
//     int maxSum = arr[0];
//     totalSum += arr[0];

//     for (int i = 1; i < arr.length; i++) {
//         totalSum += arr[i];

//         // Update current min and overall min
//         currMin = Math.min(arr[i], currMin + arr[i]);
//         minSum = Math.min(minSum, currMin);

//         // Update current max and overall max
//         currMax = Math.max(arr[i], currMax + arr[i]);
//         maxSum = Math.max(maxSum, currMax);
//     }

//     // If all elements are negative, return the maximum element
//     if (totalSum == minSum) {
//         return maxSum;
//     }

//     // Return the maximum of normal subarray and circular subarray
//     return Math.max(maxSum, totalSum - minSum);
// }
// }