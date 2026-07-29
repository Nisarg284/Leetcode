class Solution {
    public int missingNumber(int[] nums) {


        // Set<Integer> set = new HashSet<>();

        int n = nums.length;

        int sum = 0;

        for(int i : nums){
            // set.add(i);
            sum += i;
        }

        int totalSum = n * (n+1) / 2;
        return totalSum - sum;      
    }
}