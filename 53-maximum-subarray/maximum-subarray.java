class Solution {
    public int maxSubArray(int[] nums) {

        int currSum = Integer.MIN_VALUE / 2;
        int maxSum = Integer.MIN_VALUE / 2;


        for(int i = 0;i<nums.length;i++){



            if(i == 0){
                System.out.println(currSum);
                System.out.println(currSum + nums[i]);
                System.out.println();
            }
            currSum = Math.max(nums[i],currSum + nums[i]);
            if(i == 0){
                System.out.println(currSum);
                System.out.println(currSum + nums[i]);
            }

            maxSum = Math.max(maxSum,currSum);
        }

        return maxSum;
        
    }
}