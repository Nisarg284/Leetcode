class Solution {
    public long countSubarrays(int[] nums, long k) {

        long sum = 0;
        long count = 0;
        long score = 0;

        int i = 0;
        int j = 0;

        while (j < nums.length) {
            sum += nums[j];

            // score = sum * subarray length
            score = sum * (j - i + 1);

            while (i <= j && score >= k) {
                sum -= nums[i];
                i++;
                score = sum * (j - i + 1);

            }
            count += (j-i+1);
            j++;
        }

        return count;
    }
}