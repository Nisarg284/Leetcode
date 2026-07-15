class Solution {
    public int sumOfSquares(int[] nums) {

        int sum = 0;
        int n = nums.length;

        for(int i = 0;i<n;i++){

            int idx = i+1;

            if(n % idx == 0){
                sum += (int)(Math.pow(nums[i],2));
            }
        }
        return sum;
        
    }
}