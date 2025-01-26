class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;  // Update the smallest number
            } else if (num <= second) {
                second = num;  // Update the second smallest number
            } else {
                // If we find a number greater than 'second', return true
                return true;
            }
        }

        return false;  // No triplet found
    }
}
